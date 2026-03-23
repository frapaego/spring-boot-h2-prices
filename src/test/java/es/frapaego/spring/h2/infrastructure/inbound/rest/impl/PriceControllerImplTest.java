package es.frapaego.spring.h2.infrastructure.inbound.rest.impl;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import es.frapaego.spring.h2.application.find.PriceService;
import es.frapaego.spring.h2.domain.model.Price;

@SpringBootTest
class PriceControllerImplTest {

    private MockMvc mockMvc;

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceControllerImpl priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.priceController).build();
    }

    @Test
    void obtenerPrecio_returnsOk_whenServiceReturnsPrice() throws Exception {
        final LocalDateTime now = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        final Price p = Price.builder().priceList(1).productId(35455).price(35.5).curr("EUR").startDate(now).endDate(now.plusDays(1)).build();

        when(priceService.findByStartDateAndProductIdAndBrandId(eq(now), eq(35455), eq(1))).thenReturn(p);

        final String formatted = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        this.mockMvc.perform(get("/api/obtenerPrecio/1/35455").param("startDate", formatted).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void obtenerPrecio_returnsNotFound_whenServiceReturnsNull() throws Exception {
        final LocalDateTime now = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        when(priceService.findByStartDateAndProductIdAndBrandId(eq(now), eq(35455), eq(1))).thenReturn(null);

        final String formatted = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        this.mockMvc.perform(get("/api/obtenerPrecio/1/35455").param("startDate", formatted).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void obtenerPrecio_returnsInternalServerError_whenServiceThrows() throws Exception {
        final LocalDateTime now = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        when(priceService.findByStartDateAndProductIdAndBrandId(eq(now), eq(35455), eq(1))).thenThrow(new RuntimeException("boom"));

        final String formatted = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        this.mockMvc.perform(get("/api/obtenerPrecio/1/35455").param("startDate", formatted).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

}

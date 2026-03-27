package es.frapaego.spring.h2.infrastructure.inbound.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void obtenerPrecio_debeRetornarPrecioCorrecto_paraDatosEjemplo() throws Exception {
        // Arrange
        String brandId = "1";
        String productId = "35455";
        String startDate = "14-06-2020 10:00:00"; // Formato correcto dd-MM-yyyy HH:mm:ss
        // Act
        MvcResult result = mockMvc.perform(get("/api/price/" + brandId + "/" + productId)
                .param("startDate", startDate))
                .andExpect(status().isOk())
                .andReturn();
        // Assert
        String response = result.getResponse().getContentAsString();
        assertThat(response).contains("35455");
        assertThat(response).contains("1");
        assertThat(response).contains("35.5"); // precio esperado según data.sql
    }

    @Test
    void obtenerPrecio_debeRetornar404_siNoExistePrecio() throws Exception {
        mockMvc.perform(get("/api/price/1/99999")
                .param("startDate", "14-06-2020 10:00:00")) // Formato correcto
                .andExpect(status().isNotFound());
    }

    @Test
    void obtenerPrecio_debeRetornarPrecioCorrecto_enFechaLimiteInferior() throws Exception {
        String brandId = "1";
        String productId = "35455";
        String startDate = "14-06-2020 00:00:00";
        MvcResult result = mockMvc.perform(get("/api/price/" + brandId + "/" + productId)
                .param("startDate", startDate))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        assertThat(response).contains("35.5");
    }

    @Test
    void obtenerPrecio_debeRetornarPrecioCorrecto_enFechaLimiteSuperior() throws Exception {
        String brandId = "1";
        String productId = "35455";
        String startDate = "31-12-2020 23:59:59";
        MvcResult result = mockMvc.perform(get("/api/price/" + brandId + "/" + productId)
                .param("startDate", startDate))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        assertThat(response).contains("38.95");
    }

    @Test
    void obtenerPrecio_debeRetornarPrecioConMayorPrioridad() throws Exception {
        String brandId = "1";
        String productId = "35455";
        String startDate = "14-06-2020 16:00:00";
        MvcResult result = mockMvc.perform(get("/api/price/" + brandId + "/" + productId)
                .param("startDate", startDate))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        assertThat(response).contains("25.45"); // precio con prioridad 1
    }

    @Test
    void obtenerPrecio_debeRetornar400_paraFechaInvalida() throws Exception {
        mockMvc.perform(get("/api/price/1/35455")
                .param("startDate", "2020/06/14"))
                .andExpect(status().isBadRequest());
    }
}
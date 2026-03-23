package es.frapaego.spring.h2.infrastructure.inbound.rest.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PricesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    // Test 1: 2020-06-14 10:00:00 -> expected priceList 1, price 35.50
    @Test
    public void test1_priceAt20200614_1000() throws Exception {
        this.mockMvc.perform(get("/api/obtenerPrecio/1/35455").param("startDate", "14-06-2020 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5));
    }

    // Test 2: 2020-06-14 16:00:00 -> expected priceList 2, price 25.45
    @Test
    public void test2_priceAt20200614_1600() throws Exception {
        this.mockMvc.perform(get("/api/obtenerPrecio/1/35455").param("startDate", "14-06-2020 16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    // Test 3: 2020-06-14 21:00:00 -> expected priceList 1, price 35.50
    @Test
    public void test3_priceAt20200614_2100() throws Exception {
        this.mockMvc.perform(get("/api/obtenerPrecio/1/35455").param("startDate", "14-06-2020 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.price").value(35.5));
    }

    // Test 4: 2020-06-15 10:00:00 -> expected priceList 3, price 30.50
    @Test
    public void test4_priceAt20200615_1000() throws Exception {
        this.mockMvc.perform(get("/api/obtenerPrecio/1/35455").param("startDate", "15-06-2020 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.price").value(30.5));
    }

    // Test 5: 2020-06-16 21:00:00 -> expected priceList 4, price 38.95
    @Test
    public void test5_priceAt20200616_2100() throws Exception {
        this.mockMvc.perform(get("/api/obtenerPrecio/1/35455").param("startDate", "16-06-2020 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.price").value(38.95));
    }

}

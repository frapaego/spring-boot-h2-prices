package es.frapaego.spring.h2.application.find.impl;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.support.GenericConversionService;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.domain.model.Price;
import es.frapaego.spring.h2.domain.repository.BrandRepository;
import es.frapaego.spring.h2.domain.repository.PriceRepository;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DomainPriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private GenericConversionService genericConversionService;

    @InjectMocks
    private DomainPriceService domainPriceService;

    @Test
    void findByStartDateAndProductIdAndBrandId_returnsPrice_whenRepositoryReturnsDAO() {
        final LocalDateTime now = LocalDateTime.now();
        final Brand brand = Brand.builder().brandId(1).name("BrandName").build();
        final Price expected = Price.builder().priceList(1).brand(null).startDate(now.minusDays(1)).endDate(now.plusDays(1)).productId(35455).priority(0).price(35.5).curr("EUR").build();

        when(brandRepository.findByBrandId(eq(1))).thenReturn(brand);
        when(priceRepository.findByStartDateAndProductIdAndBrandId(eq(now), eq(35455), eq(brand))).thenReturn(expected);

        final Price result = domainPriceService.findByStartDateAndProductIdAndBrandId(now, 35455, 1);

        assertNotNull(result);
        assertEquals(expected.getPriceList(), result.getPriceList());
        assertEquals(expected.getProductId(), result.getProductId());
        assertEquals(expected.getPrice(), result.getPrice());
    }

    @Test
    void findByStartDateAndProductIdAndBrandId_returnsNull_whenRepositoryReturnsNull() {
        final LocalDateTime now = LocalDateTime.now();
        final Brand brand = Brand.builder().brandId(1).name("BrandName").build();
        final BrandDAO brandDAO = new BrandDAO(1, "BrandName");
        
        when(brandRepository.findByBrandId(eq(1))).thenReturn(brand);

        when(genericConversionService.convert(eq(brand), eq(BrandDAO.class))).thenReturn(brandDAO);
        when(priceRepository.findByStartDateAndProductIdAndBrandId(eq(now), eq(35455), eq(brand))).thenReturn(null);

        final Price result = domainPriceService.findByStartDateAndProductIdAndBrandId(now, 35455, 1);

        assertNull(result);
    }

}

package es.frapaego.spring.h2.infrastructure;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.domain.Pageable;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.domain.model.Price;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.PriceDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.repository.SpringDataPriceRepository;

@ExtendWith(MockitoExtension.class)
class PriceDbRepositoryTest {

    @Mock
    private SpringDataPriceRepository springDataPriceRepository;

    @InjectMocks
    private es.frapaego.spring.h2.infrastructure.outbound.db.adapter.DbPriceRepositoryAdapter priceDbRepository;

    @Mock
    private GenericConversionService genericConversionService;

    @Test
    void findByStartDateAndProductIdAndBrandId_returnsPriceDAO_whenRepositoryHasPrice() {
        final LocalDateTime now = LocalDateTime.now();
        final BrandDAO brandDAO = new BrandDAO(1, "Brand");
        final Brand brand = Brand.builder().brandId(1).name("Brand").build();
        final PriceDAO p = new PriceDAO(1, brandDAO, now.minusDays(1), now.plusDays(1), 35455, 0, 35.5, "EUR");
        final Price expected = Price.builder().priceList(1).brand(brand).startDate(now.minusDays(1)).endDate(now.plusDays(1)).productId(35455).priority(0).price(35.5).curr("EUR").build();

        when(genericConversionService.convert(eq(brand), eq(BrandDAO.class))).thenReturn(brandDAO);
        when(springDataPriceRepository.findByStartDateAndProductIdAndBrandIdOrderByPriorityDesc(eq(now), eq(35455), eq(brandDAO), ArgumentMatchers.any(Pageable.class))).thenReturn(Collections.singletonList(p));
        when(genericConversionService.convert(eq(p), eq(Price.class))).thenReturn(expected);
        

        final Price result = priceDbRepository.findByStartDateAndProductIdAndBrandId(now, 35455, brand);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void findByStartDateAndProductIdAndBrandId_returnsNull_whenRepositoryReturnsNull() {
        final LocalDateTime now = LocalDateTime.now();
        final BrandDAO brandDAO = new BrandDAO(1, "Brand");
        final Brand brand = Brand.builder().brandId(1).name("Brand").build();

        when(genericConversionService.convert(eq(brand), eq(BrandDAO.class))).thenReturn(brandDAO);
        when(springDataPriceRepository.findByStartDateAndProductIdAndBrandIdOrderByPriorityDesc(eq(now), eq(35455), eq(brandDAO), ArgumentMatchers.any(Pageable.class))).thenReturn(Collections.emptyList());

         final Price result = priceDbRepository.findByStartDateAndProductIdAndBrandId(now, 35455, brand);
         assertNull(result);
     }

 }
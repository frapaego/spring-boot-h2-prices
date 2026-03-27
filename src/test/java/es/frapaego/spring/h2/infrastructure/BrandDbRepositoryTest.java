package es.frapaego.spring.h2.infrastructure;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.support.GenericConversionService;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.repository.SpringDataBrandRepository;

@ExtendWith(MockitoExtension.class)
class BrandDbRepositoryTest {

    @Mock
    private SpringDataBrandRepository springDataBrandRepository;

    @InjectMocks
    private es.frapaego.spring.h2.infrastructure.outbound.db.adapter.DbBrandRepositoryAdapter brandDbRepository;

    @Mock
    private GenericConversionService genericConversionService;

    @Test
    void findByBrandId_returnsBrand_whenRepositoryHasBrand() {
        final BrandDAO b = new BrandDAO(1, "BrandTest");
        final Brand brand = Brand.builder().brandId(1).name("BrandTest").build();
        
        when(springDataBrandRepository.findByBrandId(eq(1))).thenReturn(b);
        when(genericConversionService.convert(eq(b), eq(Brand.class))).thenReturn(brand);

        final Brand result = brandDbRepository.findByBrandId(1);
        assertNotNull(result);
        assertEquals(brand, result);
    }

    @Test
    void findByBrandId_returnsNull_whenRepositoryReturnsNull() {
        when(springDataBrandRepository.findByBrandId(eq(2))).thenReturn(null);
        final Brand result = brandDbRepository.findByBrandId(2);
        assertNull(result);
    }

}
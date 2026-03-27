package es.frapaego.spring.h2.infrastructure.outbound.db.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.domain.repository.BrandRepository;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.repository.SpringDataBrandRepository;

/**
 * Adapter que implementa `BrandRepository` de dominio usando Spring Data JPA.
 */
@Primary
@Component
public class DbBrandRepositoryAdapter implements BrandRepository {

    @Autowired
    private SpringDataBrandRepository springDataBrandRepository;

    @Autowired
    private GenericConversionService genericConversionService;

    @Override
    public Brand findByBrandId(final Integer brandId) {
        final BrandDAO dao = this.springDataBrandRepository.findByBrandId(brandId);
        return this.genericConversionService.convert(dao, Brand.class);
    }

}

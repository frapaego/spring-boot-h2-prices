package es.frapaego.spring.h2.infrastracture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;

import es.frapaego.spring.h2.PricesH2Application;
import es.frapaego.spring.h2.domain.repository.BrandRepository;
import es.frapaego.spring.h2.domain.repository.PriceRepository;
import es.frapaego.spring.h2.domain.service.DomainPriceService;
import es.frapaego.spring.h2.domain.service.PriceService;

/**
 * BeanConfiguration
 * @author fjpaez
 *
 */
@Configuration
@ComponentScan(basePackageClasses = PricesH2Application.class)
public class BeanConfiguration {

    /**
     * @param priceRepository
     * @param brandRepository
     * @param genericConversionService
     * @return PriceService
     */
    @Bean
    PriceService priceService(final PriceRepository priceRepository, final BrandRepository brandRepository,
			final GenericConversionService genericConversionService) {
        return new DomainPriceService(priceRepository, brandRepository, genericConversionService);
    }
}

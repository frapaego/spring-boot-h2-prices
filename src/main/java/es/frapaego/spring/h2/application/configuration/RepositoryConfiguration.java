package es.frapaego.spring.h2.application.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.frapaego.spring.h2.infrastructure.outbound.db.repository.SpringDataBrandRepository;
import es.frapaego.spring.h2.infrastructure.outbound.db.repository.SpringDataPriceRepository;

/**
 * RepositoryConfiguration
 * @author frapaego@gmail.com
 *
 */
@EnableJpaRepositories(basePackageClasses = {SpringDataPriceRepository.class, SpringDataBrandRepository.class})
public class RepositoryConfiguration {

}

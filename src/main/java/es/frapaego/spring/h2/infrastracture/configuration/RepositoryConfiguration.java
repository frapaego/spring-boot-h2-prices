package es.frapaego.spring.h2.infrastracture.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.frapaego.spring.h2.infrastracture.repository.SpringDataBrandRepository;
import es.frapaego.spring.h2.infrastracture.repository.SpringDataPriceRepository;

/**
 * RepositoryConfiguration
 * @author fjpaez
 *
 */
@EnableJpaRepositories(basePackageClasses = {SpringDataPriceRepository.class, SpringDataBrandRepository.class})
public class RepositoryConfiguration {

}

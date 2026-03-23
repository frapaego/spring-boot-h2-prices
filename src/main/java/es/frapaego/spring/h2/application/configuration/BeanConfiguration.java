package es.frapaego.spring.h2.application.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import es.frapaego.spring.h2.PricesH2Application;

/**
 * BeanConfiguration
 * @author frapaego@gmail.com
 *
 */
@Configuration
@ComponentScan(basePackageClasses = PricesH2Application.class)
public class BeanConfiguration {

}

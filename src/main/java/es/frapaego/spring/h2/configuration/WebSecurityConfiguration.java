package es.frapaego.spring.h2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfiguration
 * @author frapaego@gmail.com
 *
 */
@Configuration
@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class WebSecurityConfiguration {

	/**
	 * HttpSecurity
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
		
		http
			.csrf(CsrfConfigurer::disable)
			.authorizeHttpRequests(authz -> authz.anyRequest().permitAll());
		return http.build();
	}
}

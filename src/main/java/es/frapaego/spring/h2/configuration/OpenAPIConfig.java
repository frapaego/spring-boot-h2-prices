package es.frapaego.spring.h2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * OpenAPIConfig
 * @author frapaego@gmail.com
 *
 */
@Configuration
public class OpenAPIConfig {

	/**
	 * OpenmAPI from Swagger.
	 * 
	 * @return
	 */
	@Bean
	OpenAPI myOpenAPI() {
		final Contact contact = new Contact();
		contact.setEmail("frapaego@gmail.com");
		contact.setName("Francis Páez");

		final License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

		final Info info = new Info().title("Prices Management API").version("1.0").contact(contact)
				.description("This API exposes endpoints to manage prices.").license(mitLicense);

		return new OpenAPI().info(info);
	}
}

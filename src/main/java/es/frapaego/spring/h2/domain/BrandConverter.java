package es.frapaego.spring.h2.domain;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.infrastracture.repository.BrandDAO;


/**
 * BrandConverter
 * @author frapaego@gmail.com
 *
 */
@Component
public class BrandConverter implements Converter<BrandDAO, Brand> {

	/**
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Brand convert(final BrandDAO source) {

		return Optional.ofNullable(source)
				.map(s -> Brand.builder()
						.brandId(s.getBrandId())
						.name(s.getName())
					.build())
				.orElse(null);
	}
}

package es.frapaego.spring.h2.infrastructure.outbound.db.converters;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;


/**
 * BrandDAOConverter
 * @author frapaego@gmail.com
 *
 */
@Component
public class BrandDAOConverter implements Converter<Brand, BrandDAO> {

	/**
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public BrandDAO convert(final Brand source) {

		return Optional.ofNullable(source)
				.map(s -> new BrandDAO(s.getBrandId(), s.getName()))
				.orElse(null);
	}
}

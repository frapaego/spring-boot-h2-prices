package es.frapaego.spring.h2.infrastructure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.domain.repository.BrandRepository;
import es.frapaego.spring.h2.infrastructure.outbound.db.repository.SpringDataBrandRepository;

/**
 * BrandRepositoryImpl
 * @author frapaego@gmail.com
 *
 */
@Component
public class BrandRepositoryImpl implements BrandRepository {

	@Autowired
	private SpringDataBrandRepository brandRepository;

	@Autowired
	private GenericConversionService genericConversionService;

	/**
	 * @see es.frapaego.spring.h2.domain.repository.BrandRepository#findByBrandId(java.lang.Integer)
	 */
	@Override
	public Brand findByBrandId(final Integer brandId) {
		return Optional.ofNullable(
				this.brandRepository.findByBrandId(brandId))
				.map(p -> this.genericConversionService.convert(p, Brand.class))
		.orElse(null);
	}

}

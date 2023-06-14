package es.frapaego.spring.h2.infrastracture.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.domain.repository.BrandRepository;

/**
 * BrandDbRepository
 * @author frapaego@gmail.com
 *
 */
@Component
public class BrandDbRepository implements BrandRepository {

	private final SpringDataBrandRepository brandRepository;
	
	/**
	 * @param brandRepository Brand repository
	 */
	@Autowired
	public BrandDbRepository(final SpringDataBrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}

	/**
	 * @see es.frapaego.spring.h2.domain.repository.BrandRepository#findByBrandId(java.lang.Integer)
	 */
	@Override
	public BrandDAO findByBrandId(final Integer brandId) {
		return Optional.ofNullable(
				this.brandRepository.findByBrandId(brandId))
		.orElse(null);
	}

}

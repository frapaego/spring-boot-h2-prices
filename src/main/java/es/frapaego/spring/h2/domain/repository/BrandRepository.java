package es.frapaego.spring.h2.domain.repository;

import es.frapaego.spring.h2.domain.model.Brand;

/**
 * BrandRepository
 * @author frapaego@gmail.com
 *
 */
public interface BrandRepository {

	/**
	 * Obtiene la marca indicada
	 * 
	 * @param brandId Brand Id
	 * @return Brand
	 */
	Brand findByBrandId(Integer brandId);

}

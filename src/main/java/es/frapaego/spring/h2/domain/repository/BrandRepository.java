package es.frapaego.spring.h2.domain.repository;

import es.frapaego.spring.h2.infrastracture.repository.BrandDAO;

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
	 * @return BrandDAO
	 */
	BrandDAO findByBrandId(Integer brandId);

}

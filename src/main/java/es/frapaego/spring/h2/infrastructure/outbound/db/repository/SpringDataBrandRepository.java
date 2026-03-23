package es.frapaego.spring.h2.infrastructure.outbound.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.PriceDAO;

/**
 * SpringDataBrandRepository
 * @author frapaego@gmail.com
 *
 */
public interface SpringDataBrandRepository extends JpaRepository<PriceDAO, Integer> {

	/**
	 * Obtiene la marca indicada
	 * 
	 * @param brandId Brand id
	 * @return BrandDAO
	 */
	@Query("select a from BrandDAO a where a.brandId = :brandId")
	BrandDAO findByBrandId(Integer brandId);

}

package es.frapaego.spring.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.frapaego.spring.h2.model.dao.BrandDAO;
import es.frapaego.spring.h2.model.dao.PriceDAO;

/**
 * PriceRepository
 * @author frapaego@gmail.com
 *
 */
public interface BrandRepository extends JpaRepository<PriceDAO, Integer> {

	/**
	 * Obtiene el precio de la marca y producto indicado para la fecha dada
	 * 
	 * @param startDate
	 * @param productId
	 * @param brandId
	 * @return
	 */
	@Query("select a from BrandDAO a where a.brandId = :brandId")
	BrandDAO findByBrandId(Integer brandId);

}

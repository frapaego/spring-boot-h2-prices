package es.frapaego.spring.h2.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.frapaego.spring.h2.model.dao.BrandDAO;
import es.frapaego.spring.h2.model.dao.PriceDAO;

/**
 * PriceRepository
 * @author frapaego@gmail.com
 *
 */
public interface PriceRepository extends JpaRepository<PriceDAO, Integer> {

	/**
	 * Obtiene el precio de la marca y producto indicado para la fecha dada
	 * 
	 * @param startDate
	 * @param productId
	 * @param brandId
	 * @return
	 */
	@Query("select a from PriceDAO a where a.brand = :brandId AND a.productId = :productId AND :startDate BETWEEN a.startDate AND a.endDate AND a.priority = ("
			+ "select max(b.priority) from PriceDAO b where a.brand = :brandId AND b.productId = :productId AND :startDate BETWEEN b.startDate AND b.endDate)")
	PriceDAO findByStartDateAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, BrandDAO brandId);

}

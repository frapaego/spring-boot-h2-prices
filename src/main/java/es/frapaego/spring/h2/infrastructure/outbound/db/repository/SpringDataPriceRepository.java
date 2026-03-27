package es.frapaego.spring.h2.infrastructure.outbound.db.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.PriceDAO;

/**
 * SpringDataPriceRepository
 * @author frapaego@gmail.com
 *
 */
public interface SpringDataPriceRepository extends JpaRepository<PriceDAO, Integer> {

	/**
	 * Obtiene el precio de la marca y producto indicado para la fecha dada
	 * 
	 * @param startDate Start date
	 * @param productId Product id
	 * @param brandId Brand id
	 * @return PriceDAO
	 */
	@Query("select a from PriceDAO a where a.brand = :brandId AND a.productId = :productId AND :startDate BETWEEN a.startDate AND a.endDate ORDER BY a.priority DESC")
	List<PriceDAO> findByStartDateAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime startDate, Integer productId, BrandDAO brandId, Pageable pageable);

}
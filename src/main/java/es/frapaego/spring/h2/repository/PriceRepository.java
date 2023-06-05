package es.frapaego.spring.h2.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.frapaego.spring.h2.model.dao.PriceDAO;

public interface PriceRepository extends JpaRepository<PriceDAO, Integer> {

	@Query("select a from PriceDAO a where a.brandId = :brandId AND a.productId = :productId AND :startDate BETWEEN a.startDate AND a.endDate AND a.priority = ("
			+ "select max(b.priority) from PriceDAO b where b.brandId = :brandId AND b.productId = :productId AND :startDate BETWEEN b.startDate AND b.endDate)")
	PriceDAO findByStartDateAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, Integer brandId);

}

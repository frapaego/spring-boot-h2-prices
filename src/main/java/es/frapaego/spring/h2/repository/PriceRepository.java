package es.frapaego.spring.h2.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.frapaego.spring.h2.model.dto.PriceDTO;

public interface PriceRepository extends JpaRepository<PriceDTO, Integer> {

	@Query("select a from PriceDTO a where a.brandId = :brandId AND a.productId = :productId AND :startDate BETWEEN a.startDate AND a.endDate AND a.priority = ("
			+ "select max(b.priority) from PriceDTO b where b.brandId = :brandId AND b.productId = :productId AND :startDate BETWEEN b.startDate AND b.endDate)")
	PriceDTO findByStartDateAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, Integer brandId);

}

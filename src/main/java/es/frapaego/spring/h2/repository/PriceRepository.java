package es.frapaego.spring.h2.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.frapaego.spring.h2.model.dto.PriceDTO;

public interface PriceRepository extends JpaRepository<PriceDTO, Integer> {

	@Query("select a from PriceDTO a where a.brandId = :brandId AND a.productId = :productId AND :startDate BETWEEN a.startDate AND a.endDate ORDER BY a.priority DESC")
	List<PriceDTO> findByStartDateAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, Integer brandId);

}

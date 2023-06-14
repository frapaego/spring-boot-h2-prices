package es.frapaego.spring.h2.domain.repository;

import java.time.LocalDateTime;

import es.frapaego.spring.h2.infrastracture.repository.BrandDAO;
import es.frapaego.spring.h2.infrastracture.repository.PriceDAO;

/**
 * PriceRepository
 * @author frapaego@gmail.com
 *
 */
public interface PriceRepository {

	/**
	 * Obtiene el precio de la marca y producto indicado para la fecha dada
	 * 
	 * @param startDate Start date
	 * @param productId Product id
	 * @param brandId Brand id
	 * @return PriceDAO
	 */
	PriceDAO findByStartDateAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, BrandDAO brandId);

}

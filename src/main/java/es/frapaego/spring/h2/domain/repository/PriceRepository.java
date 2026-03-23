package es.frapaego.spring.h2.domain.repository;

import java.time.LocalDateTime;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.domain.model.Price;

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
	 * @return Price
	 */
	Price findByStartDateAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, Brand brandId);

}

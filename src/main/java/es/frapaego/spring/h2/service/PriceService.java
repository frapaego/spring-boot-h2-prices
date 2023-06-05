package es.frapaego.spring.h2.service;

import java.time.LocalDateTime;

import es.frapaego.spring.h2.model.Price;

/**
 * PriceService
 * @author frapaego@gmail.com
 *
 */
public interface PriceService {

	/**
	 * Obtiene el precio de la marca y producto indicado para la fecha dada
	 * 
	 * @param startDate
	 * @param productId
	 * @param brandId
	 * @return
	 */
	Price findByStartDateAndProductIdAndBrandId(final LocalDateTime startDate, final Integer productId,
			final Integer brandId);

}

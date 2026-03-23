package es.frapaego.spring.h2.application.find;

import java.time.LocalDateTime;

import es.frapaego.spring.h2.domain.model.Price;

/**
 * PriceService
 * @author frapaego@gmail.com
 *
 */
public interface PriceService {

	/**
	 * Obtiene el precio de la marca y producto indicado para la fecha dada
	 * 
	 * @param startDate Start date
	 * @param productId Product Id
	 * @param brandId Brand Id
	 * @return Price
	 */
	Price findByStartDateAndProductIdAndBrandId(final LocalDateTime startDate, final Integer productId,
			final Integer brandId);

}

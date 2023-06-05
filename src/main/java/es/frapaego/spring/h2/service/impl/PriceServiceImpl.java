package es.frapaego.spring.h2.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

import es.frapaego.spring.h2.model.Price;
import es.frapaego.spring.h2.repository.PriceRepository;
import es.frapaego.spring.h2.service.PriceService;

/**
 * PriceServiceImpl
 * @author frapaego@gmail.com
 *
 */
@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository repository;

	@Autowired
	private GenericConversionService genericConversionService;

	/**
	 * @see es.frapaego.spring.h2.service.PriceService#findByStartDateAndProductIdAndBrandId(java.time.LocalDateTime, java.lang.Integer, java.lang.Integer)
	 */
	public Price findByStartDateAndProductIdAndBrandId(final LocalDateTime startDate, final Integer productId,
			final Integer brandId) {
		return Optional.ofNullable(
					this.repository.findByStartDateAndProductIdAndBrandId(startDate, productId, brandId))
				.map(p -> this.genericConversionService.convert(p, Price.class))
			.orElse(null);
	}

}

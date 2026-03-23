package es.frapaego.spring.h2.application.find.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.frapaego.spring.h2.application.find.PriceService;
import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.domain.model.Price;
import es.frapaego.spring.h2.domain.repository.BrandRepository;
import es.frapaego.spring.h2.domain.repository.PriceRepository;

/**
 * DomainPriceService
 * @author frapaego@gmail.com
 *
 */
@Service
public class DomainPriceService implements PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private BrandRepository brandRepository;

	/**
	 * @see es.frapaego.spring.h2.application.find.PriceService#findByStartDateAndProductIdAndBrandId(java.time.LocalDateTime, java.lang.Integer, java.lang.Integer)
	 */
	public Price findByStartDateAndProductIdAndBrandId(final LocalDateTime startDate, final Integer productId,
			final Integer brandId) {
		final Brand brand = this.brandRepository.findByBrandId(brandId);
		return Optional.ofNullable(
					this.priceRepository.findByStartDateAndProductIdAndBrandId(startDate, productId, brand))
			.orElse(null);
	}

}

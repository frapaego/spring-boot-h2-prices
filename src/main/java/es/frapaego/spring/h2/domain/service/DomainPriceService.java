package es.frapaego.spring.h2.domain.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.core.convert.support.GenericConversionService;

import es.frapaego.spring.h2.domain.Price;
import es.frapaego.spring.h2.domain.repository.BrandRepository;
import es.frapaego.spring.h2.domain.repository.PriceRepository;
import es.frapaego.spring.h2.infrastracture.repository.BrandDAO;

/**
 * DomainPriceService
 * @author frapaego@gmail.com
 *
 */
public class DomainPriceService implements PriceService {

	private final PriceRepository priceRepository;
	
	private final BrandRepository brandRepository;

	private final GenericConversionService genericConversionService;
	
	/**
	 * @param priceRepository Price repository
	 * @param brandRepository Brand repository
	 * @param genericConversionService Conversion service
	 */
	public DomainPriceService(final PriceRepository priceRepository, final BrandRepository brandRepository,
			final GenericConversionService genericConversionService) {
		super();
		this.priceRepository = priceRepository;
		this.brandRepository = brandRepository;
		this.genericConversionService = genericConversionService;
	}


	/**
	 * @see es.frapaego.spring.h2.domain.service.PriceService#findByStartDateAndProductIdAndBrandId(java.time.LocalDateTime, java.lang.Integer, java.lang.Integer)
	 */
	public Price findByStartDateAndProductIdAndBrandId(final LocalDateTime startDate, final Integer productId,
			final Integer brandId) {
		final BrandDAO brand = this.brandRepository.findByBrandId(brandId);
		return Optional.ofNullable(
					this.priceRepository.findByStartDateAndProductIdAndBrandId(startDate, productId, brand))
				.map(p -> this.genericConversionService.convert(p, Price.class))
			.orElse(null);
	}

}

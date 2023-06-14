package es.frapaego.spring.h2.infrastracture.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.domain.repository.PriceRepository;

/**
 * PriceDbRepository
 * @author frapaego@gmail.com
 *
 */
@Component
public class PriceDbRepository implements PriceRepository {

	private final SpringDataPriceRepository priceRepository;
	
	/**
	 * @param priceRepository Price repository
	 */
	@Autowired
	public PriceDbRepository(final SpringDataPriceRepository priceRepository) {
		super();
		this.priceRepository = priceRepository;
	}


	/**
	 * @see es.frapaego.spring.h2.domain.repository.PriceRepository#findByStartDateAndProductIdAndBrandId(java.time.LocalDateTime, java.lang.Integer, es.frapaego.spring.h2.infrastracture.repository.BrandDAO)
	 */
	@Override
	public PriceDAO findByStartDateAndProductIdAndBrandId(final LocalDateTime startDate, final Integer productId,
			final BrandDAO brandId) {
		return Optional.ofNullable(
				this.priceRepository.findByStartDateAndProductIdAndBrandId(startDate, productId, brandId))
		.orElse(null);
	}

}

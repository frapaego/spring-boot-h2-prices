package es.frapaego.spring.h2.infrastructure;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.domain.model.Brand;
import es.frapaego.spring.h2.domain.model.Price;
import es.frapaego.spring.h2.domain.repository.PriceRepository;
import es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO;
import es.frapaego.spring.h2.infrastructure.outbound.db.repository.SpringDataPriceRepository;

/**
 * PriceRepositoryImpl
 * @author frapaego@gmail.com
 *
 */
@Component
public class PriceRepositoryImpl implements PriceRepository {

	@Autowired
	private SpringDataPriceRepository priceRepository;
	
	@Autowired
	private GenericConversionService genericConversionService;
	
	/**
	 * @see es.frapaego.spring.h2.domain.repository.PriceRepository#findByStartDateAndProductIdAndBrandId(java.time.LocalDateTime, java.lang.Integer, es.frapaego.spring.h2.infrastructure.outbound.db.model.BrandDAO)
	 */
	@Override
	public Price findByStartDateAndProductIdAndBrandId(final LocalDateTime startDate, final Integer productId,
			final Brand brandId) {
		return Optional.ofNullable(
				this.priceRepository.findByStartDateAndProductIdAndBrandId(startDate, productId, this.genericConversionService.convert(brandId, BrandDAO.class)))
				.map(p -> this.genericConversionService.convert(p, Price.class))
		.orElse(null);
	}

}

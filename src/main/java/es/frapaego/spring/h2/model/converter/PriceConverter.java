package es.frapaego.spring.h2.model.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.model.Brand;
import es.frapaego.spring.h2.model.Price;
import es.frapaego.spring.h2.model.dao.BrandDAO;
import es.frapaego.spring.h2.model.dao.PriceDAO;

/**
 * PriceConverter
 * @author frapaego@gmail.com
 *
 */
@Component
public class PriceConverter implements Converter<PriceDAO, Price> {

	@Autowired
	private Converter<BrandDAO, Brand> brandConverter;
	
	/**
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Price convert(final PriceDAO source) {

		return Optional.ofNullable(source)
				.map(s -> Price.builder()
						.brand(Optional.ofNullable(s.getBrand()).map(this.brandConverter::convert).orElse(null))
						.startDate(s.getStartDate())
						.endDate(s.getEndDate())
						.priceList(s.getPriceList())
						.productId(s.getProductId())
						.priority(s.getPriority())
						.price(s.getPrice())
						.curr(s.getCurr())
					.build())
				.orElse(null);
	}
}

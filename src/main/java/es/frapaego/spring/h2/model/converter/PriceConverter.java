package es.frapaego.spring.h2.model.converter;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.frapaego.spring.h2.model.Price;
import es.frapaego.spring.h2.model.dao.PriceDAO;

@Component
public class PriceConverter implements Converter<PriceDAO, Price> {

	@Override
	public Price convert(final PriceDAO source) {

		return Optional.ofNullable(source)
				.map(s -> Price.builder()
						.brandId(s.getBrandId())
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

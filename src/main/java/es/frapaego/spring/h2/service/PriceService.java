package es.frapaego.spring.h2.service;

import java.time.LocalDateTime;
import java.util.List;

import es.frapaego.spring.h2.model.Price;

public interface PriceService {

	List<Price> findByStartDateProductIdBrandId(final LocalDateTime startDate, final Integer productId,
			final Integer brandId);

}

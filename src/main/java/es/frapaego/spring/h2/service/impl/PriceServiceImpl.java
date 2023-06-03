package es.frapaego.spring.h2.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

import es.frapaego.spring.h2.model.Price;
import es.frapaego.spring.h2.repository.PriceRepository;
import es.frapaego.spring.h2.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository repository;

	@Autowired
	private GenericConversionService genericConversionService;

	public List<Price> findByStartDateProductIdBrandId(final LocalDateTime startDate, final Integer productId,
			final Integer brandId) {
		return Optional.ofNullable(
					this.repository.findByStartDateAndProductIdAndBrandId(startDate, productId, brandId))
				.map(p -> (List<Price>) this.genericConversionService.convert(p, TypeDescriptor.forObject(p), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Price.class))))
			.orElse(Collections.emptyList());
	}

}

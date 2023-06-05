package es.frapaego.spring.h2.controller.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.frapaego.spring.h2.controller.PriceController;
import es.frapaego.spring.h2.exception.GenericHttpRuntimeException;
import es.frapaego.spring.h2.model.Price;
import es.frapaego.spring.h2.service.PriceService;

/**
 * PriceControllerImpl
 * @author frapaego@gmail.com
 *
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PriceControllerImpl implements PriceController {

	@Autowired
	PriceService priceService;

	/**
	 * @see es.frapaego.spring.h2.controller.PriceController#obtenerPrecio(java.lang.Integer, java.lang.Integer, java.time.LocalDateTime)
	 */
	@GetMapping(value = "/obtenerPrecio/{brandId}/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Price> obtenerPrecio(
			@PathVariable("brandId") final Integer brandId,
			@PathVariable("productId") final Integer productId,
			@RequestParam("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") final LocalDateTime startDate) {
		try {
			return Optional.ofNullable(this.priceService.findByStartDateAndProductIdAndBrandId(startDate, productId, brandId))
					.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		} catch (final Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

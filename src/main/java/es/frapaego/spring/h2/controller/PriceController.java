package es.frapaego.spring.h2.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.frapaego.spring.h2.model.Price;
import es.frapaego.spring.h2.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Prices", description = "Prices management APIs")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PriceController {

	@Autowired
	PriceService priceService;

	@Operation(summary = "Obtiene el precio de la marca y producto indicado para la fecha dada", tags = { "obtenerPrecio", "get" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Price.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "There are no Tutorials", content = {
					@Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/obtenerPrecio/{brandId}/{productId}")
	public ResponseEntity<Price> obtenerPrecio(
			@PathVariable("brandId") final Integer brandId,
			@PathVariable("productId") final Integer productId,
			@RequestParam("startDate") @Parameter(schema = @Schema(format = "dd-MM-yyyy HH:mm:ss")) 
			@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") final LocalDateTime startDate) {
		try {
			return Optional.ofNullable(this.priceService.findByStartDateProductIdBrandId(startDate, productId, brandId))
					.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		} catch (final Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

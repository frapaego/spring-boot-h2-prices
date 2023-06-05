package es.frapaego.spring.h2.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;

import es.frapaego.spring.h2.model.Price;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * PriceController
 * @author frapaego@gmail.com
 *
 */
@Tag(name = "Prices", description = "Prices management APIs")
public interface PriceController {

	/**
	 * Obtiene el precio de la marca y producto indicado para la fecha dada
	 * 
	 * @param brandId
	 * @param productId
	 * @param startDate
	 * @return
	 */
	@Operation(summary = "Obtiene el precio de la marca y producto indicado para la fecha dada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Price.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "There are no Prices", content = {
					@Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	ResponseEntity<Price> obtenerPrecio(final Integer brandId, final Integer productId,
			@Parameter(schema = @Schema(format = "dd-MM-yyyy HH:mm:ss")) final LocalDateTime startDate);
}

package es.frapaego.spring.h2.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Price
 * @author frapaego@gmail.com
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Price implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * priceList
	 */
	@Parameter(description = "Identificador de la tarifa de precios aplicable", example = "1")
	private Integer priceList;

	/**
	 * brandId
	 */
	@Parameter(description = "Identificador de la tarifa de precios aplicable", example = "1")
	private Brand brand;

	/**
	 * startDate
	 */
	private LocalDateTime startDate;

	/**
	 * endDate
	 */
	private LocalDateTime endDate;

	/**
	 * productId
	 */
	private Integer productId;

	/**
	 * priority
	 */
	private Integer priority;

	/**
	 * price
	 */
	private Double price;

	/**
	 * curr
	 */
	private String curr;

}

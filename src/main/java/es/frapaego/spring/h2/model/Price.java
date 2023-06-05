package es.frapaego.spring.h2.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
	private Integer priceList;

	/**
	 * brandId
	 */
	private Integer brandId;

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

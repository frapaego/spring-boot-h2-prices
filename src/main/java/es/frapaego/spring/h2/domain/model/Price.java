package es.frapaego.spring.h2.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

/**
 * Price
 * @author frapaego@gmail.com
 *
 */
@Value
@Builder
public class Price implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * priceList
	 */
	Integer priceList;

	/**
	 * brandId
	 */
	Brand brand;

	/**
	 * startDate
	 */
	LocalDateTime startDate;

	/**
	 * endDate
	 */
	LocalDateTime endDate;

	/**
	 * productId
	 */
	Integer productId;

	/**
	 * priority
	 */
	Integer priority;

	/**
	 * price
	 */
	Double price;

	/**
	 * curr
	 */
	String curr;

}
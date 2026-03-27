package es.frapaego.spring.h2.domain.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Value;

/**
 * Brand
 * @author frapaego@gmail.com
 *
 */
@Value
@Builder
public class Brand implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * brandId
	 */
	Integer brandId;

	/**
	 * name
	 */
	String name;

}
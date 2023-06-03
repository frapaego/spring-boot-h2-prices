package es.frapaego.spring.h2.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Price implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer priceList;

	private Integer brandId;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private Integer productId;

	private Integer priority;

	private Double price;

	private String curr;

}

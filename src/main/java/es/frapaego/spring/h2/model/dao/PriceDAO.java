package es.frapaego.spring.h2.model.dao;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * PriceDAO
 * @author frapaego@gmail.com
 *
 */
@Entity
@Table(name = "price")
public class PriceDAO {

	/**
	 * priceList
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer priceList;

	/**
	 * brandId
	 */
	@Column(name = "brand_id")
	private Integer brandId;

	/**
	 * startDate
	 */
	@Column(name = "start_date")
	private LocalDateTime startDate;

	/**
	 * endDate
	 */
	@Column(name = "end_date")
	private LocalDateTime endDate;

	/**
	 * productId
	 */
	@Column(name = "product_id")
	private Integer productId;

	/**
	 * priority
	 */
	@Column(name = "priority")
	private Integer priority;

	/**
	 * price
	 */
	@Column(name = "price")
	private Double price;

	/**
	 * curr
	 */
	@Column(name = "curr")
	private String curr;

	/**
	 * Constructor
	 */
	public PriceDAO() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param priceList
	 * @param brandId
	 * @param startDate
	 * @param endDate
	 * @param productId
	 * @param priority
	 * @param price
	 * @param curr
	 */
	public PriceDAO(final Integer priceList, final Integer brandId, final LocalDateTime startDate,
			final LocalDateTime endDate, final Integer productId, final Integer priority, final Double price,
			final String curr) {
		super();
		this.priceList = priceList;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	/**
	 * @return
	 */
	public Integer getPriceList() {
		return this.priceList;
	}

	/**
	 * @param priceList
	 */
	public void setPriceList(final Integer priceList) {
		this.priceList = priceList;
	}

	/**
	 * @return
	 */
	public Integer getBrandId() {
		return this.brandId;
	}

	/**
	 * @param brandId
	 */
	public void setBrandId(final Integer brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return
	 */
	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	/**
	 * @param startDate
	 */
	public void setStartDate(final LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return
	 */
	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	/**
	 * @param endDate
	 */
	public void setEndDate(final LocalDateTime endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return
	 */
	public Integer getProductId() {
		return this.productId;
	}

	/**
	 * @param productId
	 */
	public void setProductId(final Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return
	 */
	public Integer getPriority() {
		return this.priority;
	}

	/**
	 * @param priority
	 */
	public void setPriority(final Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * @param price
	 */
	public void setPrice(final Double price) {
		this.price = price;
	}

	/**
	 * @return
	 */
	public String getCurr() {
		return this.curr;
	}

	/**
	 * @param curr
	 */
	public void setCurr(final String curr) {
		this.curr = curr;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.brandId, this.curr, this.endDate, this.price, this.priceList, this.priority,
				this.productId, this.startDate);
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PriceDAO other = (PriceDAO) obj;
		return Objects.equals(this.brandId, other.brandId) && Objects.equals(this.curr, other.curr)
				&& Objects.equals(this.endDate, other.endDate) && Objects.equals(this.price, other.price)
				&& Objects.equals(this.priceList, other.priceList) && Objects.equals(this.priority, other.priority)
				&& Objects.equals(this.productId, other.productId) && Objects.equals(this.startDate, other.startDate);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PriceDAO [priceList=" + this.priceList + ", brandId=" + this.brandId + ", startDate=" + this.startDate
				+ ", endDate=" + this.endDate + ", productId=" + this.productId + ", priority=" + this.priority
				+ ", price=" + this.price + ", curr=" + this.curr + "]";
	}
}

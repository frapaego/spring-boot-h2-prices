package es.frapaego.spring.h2.model.dao;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "price")
public class PriceDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer priceList;

	@Column(name = "brand_id")
	private Integer brandId;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "end_date")
	private LocalDateTime endDate;

	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "priority")
	private Integer priority;

	@Column(name = "price")
	private Double price;

	@Column(name = "curr")
	private String curr;

	public PriceDAO() {
		super();
	}

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

	public Integer getPriceList() {
		return this.priceList;
	}

	public void setPriceList(final Integer priceList) {
		this.priceList = priceList;
	}

	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(final Integer brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return this.startDate;
	}

	public void setStartDate(final LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return this.endDate;
	}

	public void setEndDate(final LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(final Integer productId) {
		this.productId = productId;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(final Integer priority) {
		this.priority = priority;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(final Double price) {
		this.price = price;
	}

	public String getCurr() {
		return this.curr;
	}

	public void setCurr(final String curr) {
		this.curr = curr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.brandId, this.curr, this.endDate, this.price, this.priceList, this.priority,
				this.productId, this.startDate);
	}

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

	@Override
	public String toString() {
		return "PriceDAO [priceList=" + this.priceList + ", brandId=" + this.brandId + ", startDate=" + this.startDate
				+ ", endDate=" + this.endDate + ", productId=" + this.productId + ", priority=" + this.priority
				+ ", price=" + this.price + ", curr=" + this.curr + "]";
	}
}

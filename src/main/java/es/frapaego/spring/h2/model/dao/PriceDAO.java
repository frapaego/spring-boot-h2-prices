package es.frapaego.spring.h2.model.dao;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column(name = "price_list")
    private Integer priceList;

	/**
	 * brand
	 */
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = BrandDAO.class)
	@JoinColumn(name="brand_id", referencedColumnName = "brand_id", nullable = false)
	private BrandDAO brand;

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

	public PriceDAO() {
		super();
	}

	public PriceDAO(final Integer priceList, final BrandDAO brand, final LocalDateTime startDate, final LocalDateTime endDate,
			final Integer productId, final Integer priority, final Double price, final String curr) {
		super();
		this.priceList = priceList;
		this.brand = brand;
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

	public BrandDAO getBrand() {
		return this.brand;
	}

	public void setBrand(final BrandDAO brand) {
		this.brand = brand;
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
		return Objects.hash(this.brand, this.curr, this.endDate, this.price, this.priceList, this.priority, this.productId, this.startDate);
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
		return Objects.equals(this.brand, other.brand) && Objects.equals(this.curr, other.curr)
				&& Objects.equals(this.endDate, other.endDate) && Objects.equals(this.price, other.price)
				&& Objects.equals(this.priceList, other.priceList) && Objects.equals(this.priority, other.priority)
				&& Objects.equals(this.productId, other.productId) && Objects.equals(this.startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "PriceDAO [priceList=" + this.priceList + ", brand=" + this.brand + ", startDate=" + this.startDate + ", endDate="
				+ this.endDate + ", productId=" + this.productId + ", priority=" + this.priority + ", price=" + this.price + ", curr="
				+ this.curr + "]";
	}

}

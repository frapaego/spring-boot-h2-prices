package es.frapaego.spring.h2.model.dao;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brand")
public class BrandDAO {
	/**
	 * brandId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
    private Integer brandId;

	/**
	 * name
	 */
	@Column(name = "name")
	private String name;
	
	public BrandDAO() {
		super();
	}

	public BrandDAO(final Integer brandId, final String name) {
		super();
		this.brandId = brandId;
		this.name = name;
	}

	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(final Integer brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.brandId, this.name);
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
		final BrandDAO other = (BrandDAO) obj;
		return Objects.equals(this.brandId, other.brandId) && Objects.equals(this.name, other.name);
	}

	@Override
	public String toString() {
		return "BrandDAO [brandId=" + this.brandId + ", name=" + this.name + "]";
	}

}

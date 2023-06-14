package es.frapaego.spring.h2.infrastracture.repository;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * BrandDAO
 * @author fjpaez
 *
 */
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
	
	/**
	 * Constructor
	 */
	public BrandDAO() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param brandId Brand Id
	 * @param name Name
	 */
	public BrandDAO(final Integer brandId, final String name) {
		super();
		this.brandId = brandId;
		this.name = name;
	}

	/**
	 * @return brandId
	 */
	public Integer getBrandId() {
		return this.brandId;
	}

	/**
	 * @param brandId Brand Id
	 */
	public void setBrandId(final Integer brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name Name
	 */
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

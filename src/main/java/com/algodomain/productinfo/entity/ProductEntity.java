package com.algodomain.productinfo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ProductInfo")
public class ProductEntity {
	@Id
	private int id;
	private String productName;
	private String productType;
	@Column(name="Category", nullable=false, length=512)
	private String productCategory;
	private double price;
	
	@ManyToMany(mappedBy="products" , cascade=CascadeType.PERSIST)
	private List<TypeEntity> categories =new ArrayList<>();

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(int id, String productName, String productType, String productCategory, double price,
			List<TypeEntity> categories) {
		super();
		this.id = id;
		this.productName = productName;
		this.productType = productType;
		this.productCategory = productCategory;
		this.price = price;
		this.categories = categories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<TypeEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<TypeEntity> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", productName=" + productName + ", productType=" + productType
				+ ", productCategory=" + productCategory + ", price=" + price + ", categories=" + categories + "]";
	}
	
	
	
	
	
}

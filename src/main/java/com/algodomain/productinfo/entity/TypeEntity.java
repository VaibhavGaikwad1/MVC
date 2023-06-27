package com.algodomain.productinfo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Type")
public class TypeEntity {
	
	@Id
	private int id;
	private String category;
	private String discount;

	@ManyToMany
	private List<ProductEntity> products=new ArrayList<>();

	public TypeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeEntity(int id, String category, String discount, List<ProductEntity> products) {
		super();
		this.id = id;
		this.category = category;
		this.discount = discount;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "TypeEntity [id=" + id + ", category=" + category + ", discount=" + discount + ", products=" + products
				+ "]";
	}
	
	
	
}

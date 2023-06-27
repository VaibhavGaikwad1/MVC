package com.algodomain.productinfo.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algodomain.productinfo.dao.ProductRepository;
import com.algodomain.productinfo.entity.ProductEntity;

@Component
public class ProductService {
	@Autowired
	private ProductRepository pr;

//1
	public List<ProductEntity> getAllProduct() {
		List<ProductEntity> list = (List<ProductEntity>) this.pr.findAll();
		return list;
	}

//2
	public ProductEntity getProductbyId(int id) {
		ProductEntity productEntity = new ProductEntity();
		productEntity = this.pr.findById(id);

		return productEntity;
	}

//3
	public ProductEntity addProduct(ProductEntity b) {
		ProductEntity result = pr.save(b);
		return b;
	}

//4
	public void deleteProduct(int bid) {
		pr.deleteById(bid);
	}

//5
	public ProductEntity updateProduct(ProductEntity product,int productid) {
		List<ProductEntity> list = (List<ProductEntity>) this.pr.findAll();
		list =list.stream().map(b->{
			if(b.getId()==productid) {
			//	b.setPrice(product.getPrice());
			//	b.setProductCategry(product.getProductCategry());
			//	b.setProductName(product.getProductName());
			//	b.setProductType(product.getProductType());
			
				ProductEntity result = pr.save(product);
				return product;
				}
			return b;
		}).collect(Collectors.toList()); 
		return product;
		
	}

	
}

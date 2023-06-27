package com.algodomain.productinfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.algodomain.productinfo.entity.ProductEntity;
import com.algodomain.productinfo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productservice;

//All Product Data	
	@GetMapping("/product")
	public ResponseEntity<List<ProductEntity>> getProduct() {

		List<ProductEntity> list = ((ProductService) productservice).getAllProduct();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

//Only 1 product data by using id
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductEntity> getBook(@PathVariable("id") int id) {
		ProductEntity product = productservice.getProductbyId(id);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(product));
	}

//Adding Data into database
	@PostMapping("/product")
	public ResponseEntity<ProductEntity> addproduct(@RequestBody ProductEntity product) {
		ProductEntity b = null;
		try {
			b = this.productservice.addProduct(product);
			System.out.println(product);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

//Delete Product handler
	@DeleteMapping("/product/{productid}")
	public void deleteProduct(@PathVariable("productId") int productid) {
		ProductEntity b = productservice.getProductbyId(productid);
		System.out.println(b);

		this.productservice.deleteProduct(productid);

	}

//Update product	
	
	@PutMapping("/product/{productid}")
	public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity product,@PathVariable("productid") int productid) {
		try {
			this.productservice.updateProduct(product,productid);
			return ResponseEntity.ok().body(product);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
	}


}

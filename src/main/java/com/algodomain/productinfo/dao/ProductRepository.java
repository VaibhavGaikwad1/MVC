package com.algodomain.productinfo.dao;

import org.springframework.data.repository.CrudRepository;

import com.algodomain.productinfo.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {

	public ProductEntity findById(int id);
	public void deleteById(int id);
}

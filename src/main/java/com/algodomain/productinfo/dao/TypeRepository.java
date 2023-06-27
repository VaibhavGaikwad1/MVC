package com.algodomain.productinfo.dao;

import org.springframework.data.repository.CrudRepository;

import com.algodomain.productinfo.entity.TypeEntity;

public interface TypeRepository extends CrudRepository<TypeEntity,Integer>{
	public TypeEntity findById(int id);
	public void deleteById(int id);
	public void getTypeById(int id);

}

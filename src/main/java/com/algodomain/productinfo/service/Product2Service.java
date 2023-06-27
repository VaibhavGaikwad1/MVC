package com.algodomain.productinfo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.algodomain.productinfo.dao.Product2Repository;
import com.algodomain.productinfo.dao.TypeRepository;
import com.algodomain.productinfo.entity.TypeEntity;

public class Product2Service {
	@Autowired
	private Product2Repository pr;
	@Autowired
	private TypeRepository tr;
	
	
//POst operation
	public TypeEntity addType(TypeEntity b) {
		TypeEntity result = tr.save(b);
		return b;
	}
//getOPerationAll
	public List<TypeEntity> getAllType() {
		List<TypeEntity> list = (List<TypeEntity>) this.tr.findAll();
		return list;
	}
	
/*	
//for get only
	public TypeEntity getTypebyId(int id) {
		TypeEntity typeEntity = new TypeEntity();
		typeEntity = this.tr.findById(id);

		return typeEntity;
	}*/
//for delete
	public void deleteType(int bid) {
		pr.deleteById(bid);
	}
	
//FOR put method
	public TypeEntity updateType(TypeEntity Type,int typeid) {
		List<TypeEntity> list = (List<TypeEntity>) this.tr.findAll();
		list =list.stream().map(b->{
			if(b.getId()==typeid) {
			//	b.setPrice(product.getPrice());
			//	b.setProductCategry(product.getProductCategry());
			//	b.setProductName(product.getProductName());
			//	b.setProductType(product.getProductType());
			
				TypeEntity result = tr.save(Type);
				return Type;
				}
			return b;
		}).collect(Collectors.toList()); 
		return Type;
		
	}
	public TypeEntity getTypeById(int typeid) {
		// TODO Auto-generated method stub
		return null;
	}
}

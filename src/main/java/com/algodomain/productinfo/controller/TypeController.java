package com.algodomain.productinfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.algodomain.productinfo.entity.TypeEntity;
import com.algodomain.productinfo.service.Product2Service;

@RestController
public class TypeController {
	
	private Product2Service typeService;

//All TYpe Data	
		@GetMapping("/type")
		public ResponseEntity<List<TypeEntity>> getType() {

			List<TypeEntity> list = typeService.getAllType();
			/*	if (list.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} */
			return ResponseEntity.of(Optional.of(list));
		}
		
//Type Post
		//Adding Data into database
		@PostMapping("/type")
		public ResponseEntity<TypeEntity> addproduct(@RequestBody TypeEntity type) {
			TypeEntity b = null;
			try {
				b = this.typeService.addType(type);
				System.out.println(type);
				return ResponseEntity.status(HttpStatus.CREATED).build();
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		}
		
/*		
//Delete Product handler
		@DeleteMapping("/type/{typeid}")
		public void deleteProduct(@PathVariable("typeId") int typeid) {
			TypeEntity b = ((Product2Service) typeService).getTypeById(typeid);
			System.out.println(b);

			this.typeService.deleteType(typeid);

		}
		*/

//Update product	
		
		@PutMapping("/type/{typeid}")
		public ResponseEntity<TypeEntity> updateProduct(@RequestBody TypeEntity type,@PathVariable("typeid") int typeid) {
			try {
				this.typeService.updateType(type,typeid);
				return ResponseEntity.ok().body(type);
			}catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
			
			
		}

}

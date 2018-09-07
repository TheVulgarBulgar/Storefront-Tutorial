package com.accenture;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDB;
	
	public Collection<Product> getAllProducts(){
		return this.productDB.getAllProducts();
	}

	public Product getProductById(int id) {
		return this.productDB.getProductById(id);
	}

	public void removeProductById(int id) {
		this.productDB.removeProductById(id);
		
	}
	
	public void updateProduct(Product product){
		this.productDB.updateProduct(product);
	}
	
	public void insertStudent(Product product){
		this.productDB.insertStudent(product);
	}
}

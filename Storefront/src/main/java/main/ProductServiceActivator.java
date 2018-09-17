package main;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceActivator {
	
	@Autowired
	public ProductService productService;
	
	public ProductServiceActivator(){
		
	}
}

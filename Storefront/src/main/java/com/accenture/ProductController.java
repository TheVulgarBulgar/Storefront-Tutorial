package com.accenture;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Product> getAllProducts(){
		return this.productService.getAllProducts();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Product getProductById(@PathVariable("id") int id) {
		return this.productService.getProductById(id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteProductById(@PathVariable("id") int id) {
		productService.removeProductById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateProduct(@RequestBody Product product){
		this.productService.updateProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void insertStudent(@RequestBody Product product){
		this.productService.insertStudent(product);
	}
}

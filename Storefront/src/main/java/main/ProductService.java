package main;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productDB;
	
	public Iterable<Product> getAllProducts(){
		return this.productDB.findAll();
	}

	public Optional<Product> getProductById(int id) {
		return this.productDB.findById(id);
	}

	public void removeProductById(int id) {
		this.productDB.deleteById(id);
		
	}
	
	public void updateProduct(Product product){
		Product P = this.productDB.getOne(product.getId());
		this.productDB.save(P);
	}
	
	public void insertStudent(Product product){
		this.productDB.save(product);
	}
}

package main;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
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
	
	public void delete(Product product) {
		this.productDB.delete(product);
	}
	
	public void updateProduct(Product product){
		Product P = this.productDB.getOne(product.getId());
		P.setName(product.getName());
		P.setDescription(product.getDescription());
		this.productDB.save(P);
	}
	
	public void insertProduct(Product product){
		this.productDB.save(product);
	}
	
	public Message printProduct(Message message) {
		String[] newProducts = message.getPayload().toString().split("\\r?\\n");
		
		for(String i: newProducts) {
			String[] productProperties = i.split(";");
			
			try{
				try {
					int id = Integer.parseInt(productProperties[0]);
					Product product = new Product(id, productProperties[1], productProperties[2]);
					Optional<Product> inDBProduct = getProductById(id);
					try {
						Product newProduct = inDBProduct.get();
						updateProduct(product);
					}
					catch(Exception e) {
						insertProduct(product);
					}
				}
				catch(NumberFormatException e) {
					System.out.println("This line contained an invalid product id. Skipping.");
				}
			}
			catch(NullPointerException e) {
				System.out.println("The system repository was set to null");
			}
		}
		return message;
	}
}

package com.accenture;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductDaoImpl implements ProductDao {
	
	private static Map<Integer, Product> products;
	
	static {
		products = new HashMap<Integer, Product>(){
			{
				put(1, new Product(1, "Razer Blade","A thin-and-light gaming laptop"));
				put(2, new Product(2, "Bose MX5 Headphones","Noise-canceling headphones suitable for long-distance travel"));
				put(3, new Product(3, "SteelSeries Rival","A high-dpi gaming mouse at a low cost"));
			}
		};
	} 
	
	/* (non-Javadoc)
	 * @see com.accenture.ProductDao#getAllProducts()
	 */
	@Override
	public Collection<Product> getAllProducts(){	
		return this.products.values();
	}

	/* (non-Javadoc)
	 * @see com.accenture.ProductDao#getProductById(int)
	 */
	@Override
	public Product getProductById(int id) {
		return this.products.get(id);
	}

	/* (non-Javadoc)
	 * @see com.accenture.ProductDao#removeProductById(int)
	 */
	@Override
	public void removeProductById(int id) {
		this.products.remove(id);
	}
	
	/* (non-Javadoc)
	 * @see com.accenture.ProductDao#updateProduct(com.accenture.Product)
	 */
	@Override
	public void updateProduct(Product product){
		Product p = this.getProductById(product.getId());
		p.setDescription(product.getDescription());
		p.setName(product.getName());
		this.products.put(product.getId(), p);
	}
	
	/* (non-Javadoc)
	 * @see com.accenture.ProductDao#insertStudent(com.accenture.Product)
	 */
	@Override
	public void insertStudent(Product product){
		this.products.put(product.getId(), product);
	}
}

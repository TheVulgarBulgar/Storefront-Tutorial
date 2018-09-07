package com.accenture;

import java.util.Collection;

public interface ProductDao {

	Collection<Product> getAllProducts();

	Product getProductById(int id);

	void removeProductById(int id);

	void updateProduct(Product product);

	void insertStudent(Product product);

}
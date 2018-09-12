package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartItem {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private int productKey;
	@Column
	private short quantity;
	
	public CartItem() {
		
	}
	
	public CartItem(int id, int productKey, short quantity) {
		this.id = id;
		this.productKey = productKey;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductKey() {
		return productKey;
	}

	public void setProductKey(int productKey) {
		this.productKey = productKey;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
}

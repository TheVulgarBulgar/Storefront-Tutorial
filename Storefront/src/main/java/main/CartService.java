package main;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartItemDB;
	
	public Iterable<CartItem> getAllCartItems(){
		return this.cartItemDB.findAll();
	}

	public Optional<CartItem> getCartItemById(int id) {
		return this.cartItemDB.findById(id);
	}

	public void removeCartItemById(int id) {
		this.cartItemDB.deleteById(id);
		
	}
	
	public void delete(CartItem cartItem) {
		this.cartItemDB.delete(cartItem);
	}
	
	public void insertCartItem(CartItem cartItem){		
		try{
			
			Optional<CartItem> P = this.cartItemDB.findAll().stream().filter(c -> c.getProductKey() == cartItem.getProductKey()).findFirst();
			CartItem newCartItem = P.get();
			newCartItem.setQuantity(cartItem.getQuantity());			
			System.out.println(String.valueOf(newCartItem.getQuantity()));
			this.updateCartItem(newCartItem);
		}
		catch(Exception e){
			if(cartItem.getQuantity() < 1) {
				cartItem.setQuantity((short)1);
			}			
			this.cartItemDB.save(cartItem);
			System.out.println("found a new cart item");
		}		
	}
	
	public void updateCartItem(CartItem cartItem){
		CartItem P = this.cartItemDB.getOne(cartItem.getId());
		P.setQuantity(cartItem.getQuantity());
		if(P.getQuantity() < 1) {
			P.setQuantity((short)1);
		}
		this.cartItemDB.save(P);
		System.out.println(String.valueOf(P.getQuantity()));
		System.out.println("found an existing cart item");
	}	
}

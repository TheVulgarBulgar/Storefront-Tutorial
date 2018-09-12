package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProductAndCartController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping(value="/addQuantityToCart")
	public String insertCartItem(@RequestParam(value="productId") int productId, @RequestParam(value="quantity") int quantity) {
		
		CartItem cartItem = new CartItem();
		cartItem.setProductKey(productId);
		cartItem.setQuantity((short)quantity);
		
		System.out.println(String.valueOf(quantity));
		
		this.cartService.insertCartItem(cartItem);
		
		return "redirect:cart";
	}
	
	@GetMapping("cart")
	public String cart() {		
		return "cart";
	}
	
	// product service request methods
	@ModelAttribute("cartItems")
	public Iterable<CartItem> GetAllCartItems(){
		return this.cartService.getAllCartItems();		
	}
	
	@ModelAttribute("products")
	public Iterable<Product> GetAllProducts(){
		return this.productService.getAllProducts();		
	}
	
	
	@RequestMapping(value="/products/{id}", method = RequestMethod.GET)
	public Optional<Product> getProductById(@PathVariable("id") int id) {
		return this.productService.getProductById(id);
	}	
	@RequestMapping(value="/products/{product.id}", method = RequestMethod.DELETE)
	public void deleteProductById(@PathVariable("id") int id) {
		productService.removeProductById(id);
	}	
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateProduct(@RequestBody Product product){
		this.productService.updateProduct(product);
	}
	@PostMapping("products")
	public void insertProduct(@ModelAttribute Product product){
		this.productService.insertProduct(product);
	}	
	@ModelAttribute("product")
	@GetMapping("add")
	public Product AddProduct() {
		return new Product();
	}	
	
	@PostMapping("products/delete")
	public void deleteFromCart(@RequestBody Product product) {
		this.productService.delete(product);
	}
	@GetMapping("delete/product/{product.id}")
	public void deleteFromCart(@PathVariable("product.id") int id) {
		this.productService.removeProductById(id);
	}
	
	@GetMapping("delete/{cartItem.id}")
	public String deleteCartItemFromCart(@PathVariable("cartItem.id") int id) {
		this.cartService.removeCartItemById(id);
		return "redirect:../cart";
	}
	
	// product service reponse methods
	// cart service methods
	
}

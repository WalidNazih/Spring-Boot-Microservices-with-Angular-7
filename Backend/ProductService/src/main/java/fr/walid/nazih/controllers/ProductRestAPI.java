package fr.walid.nazih.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.walid.nazih.models.Product;
import fr.walid.nazih.services.IStockService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductRestAPI {

	@Autowired
	private IStockService stockService;
	
	@GetMapping
	public Collection<Product> getAllProducts() {
		return stockService.getAllProducts();
	}
	
	@PostMapping
	public @ResponseBody Product addProduct(@RequestBody Product product) {
		return stockService.addProduct(product);
	}
	
	@PutMapping
	public @ResponseBody Product updateProduct(@RequestBody Product product) {
		return stockService.updateProduct(product);
	}
	
	@DeleteMapping("{id}")
	public void deleteProduct(@PathVariable Long id) {
		stockService.deleteProductById(id);
	}
	
	@GetMapping("/category/{id}")
	public Collection<Product> getProductsByCategoryId(@PathVariable Long id){
		return stockService.getProductsByCategoryId(id);
	}
	
	@GetMapping("{name}")
	public Product getProductByName(@PathVariable String name){
		return stockService.getProductByName(name);
	}
	
	@PutMapping("/category/{productId}/{categoryId}")
	public void addProductToCategory(@PathVariable Long productId, @PathVariable Long categoryId) {
		stockService.addProductToCategory(categoryId, productId);
	}
	
	
	
}

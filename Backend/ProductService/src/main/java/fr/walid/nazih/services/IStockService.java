package fr.walid.nazih.services;

import java.util.Collection;

import fr.walid.nazih.models.Category;
import fr.walid.nazih.models.Product;

public interface IStockService {
	
	Collection<Product> getAllProducts();
	Collection<Product> getProductsByCategoryId(Long id);
	Collection<Product> getProductByName(String name);
	Product addProduct(Product product);
	Product updateProduct(Product product);
	void deleteProductById(Long id);
	
	Collection<Category> getAllCategories();
	Category addCategory(Category category);
	Category updateCategory(Category category);
	void deleteCategoryById(Long id);
	
	void addProductToCategory(Long categoryId, Long productId);
}

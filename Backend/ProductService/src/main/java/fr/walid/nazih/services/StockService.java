package fr.walid.nazih.services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.walid.nazih.models.Category;
import fr.walid.nazih.models.Product;
import fr.walid.nazih.repositories.CategoryRepository;
import fr.walid.nazih.repositories.ProductRepository;

@Service
@Transactional
public class StockService implements IStockService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private IJMSService jmsService;
	

	@Override
	public Collection<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Collection<Product> getProductsByCategoryId(Long id) {
		return productRepository.findAllByCategoryId(id);
	}

	@Override
	public Collection<Product> getProductByName(String name) {
		return productRepository.findByNameContains(name);
	}

	@Override
	public Product addProduct(Product product) {
		jmsService.sendMessage("product_topic", "Added new product " + product.getName());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		jmsService.sendMessage("product_topic", "Updated Product " + product.getId());
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Long id) {
		jmsService.sendMessage("product_topic", "Deleted product " + id);
		productRepository.deleteById(id);
	}

	@Override
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void addProductToCategory(Long categoryId, Long productId) {
		
		Category category = categoryRepository.getOne(categoryId);
		Product product = productRepository.getOne(productId);
		
		product.setCategory(category);
		
	}


	
	
}

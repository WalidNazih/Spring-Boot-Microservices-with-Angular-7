package fr.walid.nazih.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.walid.nazih.models.Category;
import fr.walid.nazih.services.IStockService;

@RestController
@RequestMapping("/api/categories")
public class CategoryRestAPI {

	@Autowired
	private IStockService stockService;
	
	@GetMapping
	public Collection<Category> getAllCategories() {
		return stockService.getAllCategories();
	}
	
	@PostMapping
	public @ResponseBody Category addCategory(@RequestBody Category category) {
		return stockService.addCategory(category);
	}
	
	@PutMapping
	public @ResponseBody Category updateCategory(@RequestBody Category category) {
		return stockService.updateCategory(category);
	}
	
	@DeleteMapping("{id}")
	public void deleteCategory(@PathVariable Long id) {
		stockService.deleteCategoryById(id);
	}
	
}

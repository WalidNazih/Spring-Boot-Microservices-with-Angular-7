package fr.walid.nazih;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.walid.nazih.models.Category;
import fr.walid.nazih.services.IStockService;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner{
	
	@Autowired
	private IStockService stockService;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category smartPhonesCategory = new Category();
		smartPhonesCategory.setName("Smartphones");
		
		Category consolesCategory = new Category();
		consolesCategory.setName("Consoles");
		
		stockService.addCategory(smartPhonesCategory);
		stockService.addCategory(consolesCategory);
		
		
	}

}

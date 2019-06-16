package fr.walid.nazih.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.walid.nazih.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Collection<Product> findAllByCategoryId(Long id);
	Collection<Product> findByNameContains(String name);
	
}

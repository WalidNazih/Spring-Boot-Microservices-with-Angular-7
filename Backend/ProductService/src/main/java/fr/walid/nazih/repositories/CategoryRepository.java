package fr.walid.nazih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.walid.nazih.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

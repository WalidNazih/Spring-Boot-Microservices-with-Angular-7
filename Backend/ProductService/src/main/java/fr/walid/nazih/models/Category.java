package fr.walid.nazih.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
	
	@Id @GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="category")
	@JsonIgnore
	private Collection<Product> produits;

}

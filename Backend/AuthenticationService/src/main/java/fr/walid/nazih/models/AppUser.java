package fr.walid.nazih.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
	
	@Id
	private String username;
	private String password;
	private boolean enabled;
	
	@ManyToMany
	private Collection<AppRole> roles;

}

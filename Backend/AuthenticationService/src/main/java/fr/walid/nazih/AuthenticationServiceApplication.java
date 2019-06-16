package fr.walid.nazih;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.walid.nazih.models.AppRole;
import fr.walid.nazih.models.AppUser;
import fr.walid.nazih.repositories.AppRoleRepository;
import fr.walid.nazih.repositories.AppUserRepository;

@SpringBootApplication
public class AuthenticationServiceApplication implements CommandLineRunner{
	
	@Autowired
	private AppUserRepository userRepo;
	@Autowired
	private AppRoleRepository roleRepo;
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder BC() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		AppRole role = new AppRole();
		role.setRole("ADMIN");
		
		final AppRole role1 = roleRepo.save(role);
		userRepo.save(new AppUser("walid", bCrypt.encode("nazih"), true, new ArrayList<AppRole>() {{add(role);}}));
		
	}

}

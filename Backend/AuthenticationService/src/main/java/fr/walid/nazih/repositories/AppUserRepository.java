package fr.walid.nazih.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.walid.nazih.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{

}

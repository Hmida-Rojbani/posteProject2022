package tn.poste.projet.repositories.security;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.projet.entities.security.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
}
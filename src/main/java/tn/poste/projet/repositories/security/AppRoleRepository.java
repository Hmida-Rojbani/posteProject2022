package tn.poste.projet.repositories.security;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.projet.entities.security.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    public AppRole findByRoleName(String roleName);
}
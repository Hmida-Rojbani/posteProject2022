package tn.poste.projet.services.security;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import tn.poste.projet.entities.security.AppRole;
import tn.poste.projet.entities.security.AppUser;
import tn.poste.projet.repositories.security.AppRoleRepository;
import tn.poste.projet.repositories.security.AppUserRepository;

@Service
@AllArgsConstructor
@Transactional
public class AccountService {
  private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;    

    public AppUser saveUser(String username, String password, String confirmedPassword ,String phoneNumber, String gender , String address) {
        AppUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setGender(gender);
        appUser.setPhoneNumber(phoneNumber);
        appUser.setAddress(address);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(confirmedPassword));
       
        appUserRepository.save(appUser);
        addRoleToUser(username,"ROLE_USER");
        return appUser;
    }

	public AppUser saveFournisseur(String username, String password, String confirmedPassword, String phoneNumber,
			String gender, String address) {
		AppUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("Fournisseur already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setGender(gender);
        appUser.setPhoneNumber(phoneNumber);
        appUser.setAddress(address);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(confirmedPassword));
       
        appUserRepository.save(appUser);
        addRoleToUser(username,"ROLE_FOURNISSEUR");
        System.out.println(appUser.getRoles());
        return appUser;
	}
   
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }

}
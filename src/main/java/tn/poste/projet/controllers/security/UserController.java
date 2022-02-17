package tn.poste.projet.controllers.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import tn.poste.projet.entities.security.AppUser;
import tn.poste.projet.services.security.AccountService;

@RestController
public class UserController {
  @Autowired
    private AccountService accountService;//UserForm userForm
    @PostMapping("/registerUser")
    public AppUser registerUser(@RequestBody  UserForm userForm){
        return  accountService.saveUser(userForm.getUsername(), userForm.getPassword(),userForm.getConfirmedPassword()
        		    ,userForm.getPhoneNumber() ,userForm.getGender(),userForm.getAddress());
    }
    @PostMapping("/registerFour")
    public AppUser registerFournisseur(@RequestBody  UserForm userForm){
        return  accountService.saveFournisseur(userForm.getUsername(), userForm.getPassword(),userForm.getConfirmedPassword()
        		    ,userForm.getPhoneNumber() ,userForm.getGender(),userForm.getAddress());
    }
    
}

@Data
class UserForm{
    private String username;
    private String password;
    private String confirmedPassword;
    private String phoneNumber ;
    private String gender;
    private String address;
    
}

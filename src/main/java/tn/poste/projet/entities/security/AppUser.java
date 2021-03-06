package tn.poste.projet.entities.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column
    private String address;
    
    @Column()
    private String phoneNumber;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @Column()
    private boolean actived;
    
    private String confirmedPassword; 
    
    @Column()
    private String gender;
    
    public AppUser(String username , String password,String confirmedPassword ) {
    	this.username = username;
    	this.password = password;
    	this.confirmedPassword = confirmedPassword;
    }
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();
}
package diam.spring.springsecurity.Services;

import diam.spring.springsecurity.Entities.AppRoles;
import diam.spring.springsecurity.Entities.AppUser;

import java.util.List;

public interface AccountService {

    AppUser addNewUser(AppUser appUser);
    AppRoles addNewRole(AppRoles appRoles);
    void addRoleToUser(String userName, String roleName);
    // charger l'utilisateur par son nom dutilisateur
    AppUser loadUserByUserName(String userName);

    //La Liste des user
    List<AppUser> listUsers();

}

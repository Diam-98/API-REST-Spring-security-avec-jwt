package diam.spring.springsecurity.Services;

import diam.spring.springsecurity.Entities.AppRoles;
import diam.spring.springsecurity.Entities.AppUser;
import diam.spring.springsecurity.Repositories.AppRolesRepository;
import diam.spring.springsecurity.Repositories.AppUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AppUserRepository appUserRepository;
    private final AppRolesRepository appRolesRepository;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRolesRepository appRolesRepository) {
        this.appUserRepository = appUserRepository;
        this.appRolesRepository = appRolesRepository;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        String password = appUser.getPassword();
        appUser.setPassword(passwordEncoder().encode(password));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRoles addNewRole(AppRoles appRoles) {
        return appRolesRepository.save(appRoles);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser appUser = appUserRepository.findByUserName(userName);
        AppRoles appRoles = appRolesRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRoles);
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}

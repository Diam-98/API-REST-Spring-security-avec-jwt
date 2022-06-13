package diam.spring.springsecurity.Services;

import diam.spring.springsecurity.Entities.AppRoles;
import diam.spring.springsecurity.Entities.AppUser;
import diam.spring.springsecurity.Repositories.AppRolesRepository;
import diam.spring.springsecurity.Repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRolesRepository appRolesRepository;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRolesRepository appRolesRepository) {
        this.appUserRepository = appUserRepository;
        this.appRolesRepository = appRolesRepository;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
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
        return null;
    }

    @Override
    public List<AppUser> listUsers() {
        return null;
    }
}

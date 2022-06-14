package diam.spring.springsecurity.Web;

import diam.spring.springsecurity.Entities.AppRoles;
import diam.spring.springsecurity.Entities.AppUser;
import diam.spring.springsecurity.Services.AccountService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private final AccountService accountServices;

    public AccountRestController(AccountService accountServices) {
        this.accountServices = accountServices;
    }

    @GetMapping(path = "/users")
    public List<AppUser> appUsers(){
        return accountServices.listUsers();
    }

    @PostMapping(path = "/user")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountServices.addNewUser(appUser);
    }

    @PostMapping(path = "roles")
    public AppRoles saveRoles(@RequestBody AppRoles appRoles){
        return accountServices.addNewRole(appRoles);
    }

    @PostMapping(path = "addRolesToUser")
    public void addRolesToUsers(@RequestBody RoleUserForm roleUserForm){
        accountServices.addRoleToUser(roleUserForm.getUserName(), roleUserForm.getRoleName());
    }
}

@Data
class RoleUserForm{
    private String userName;
    private String roleName;
}

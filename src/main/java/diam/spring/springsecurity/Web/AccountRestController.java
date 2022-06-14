package diam.spring.springsecurity.Web;

import diam.spring.springsecurity.Entities.AppUser;
import diam.spring.springsecurity.Services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
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
}

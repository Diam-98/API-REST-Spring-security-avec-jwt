package diam.spring.springsecurity;

import diam.spring.springsecurity.Entities.AppRoles;
import diam.spring.springsecurity.Entities.AppUser;
import diam.spring.springsecurity.Services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    // Test fonctionnel des implemntations
    @Bean
    CommandLineRunner start(AccountService accountServices){
        return args -> {
            accountServices.addNewRole(new AppRoles(null, "USER"));
            accountServices.addNewRole(new AppRoles(null, "ADMIN"));
            accountServices.addNewRole(new AppRoles(null, "CUSTOMER_MANAGER"));
            accountServices.addNewRole(new AppRoles(null, "PRODUCT_MANAGER"));
            accountServices.addNewRole(new AppRoles(null, "BILLS_MANAGER"));

            accountServices.addNewUser(new AppUser(null, "user1", "1234", new ArrayList<>()));
            accountServices.addNewUser(new AppUser(null, "admin", "1234", new ArrayList<>()));
            accountServices.addNewUser(new AppUser(null, "user2", "1234", new ArrayList<>()));
            accountServices.addNewUser(new AppUser(null, "user3", "1234", new ArrayList<>()));
            accountServices.addNewUser(new AppUser(null, "user4", "1234", new ArrayList<>()));

            accountServices.addRoleToUser("user1", "USER");
            accountServices.addRoleToUser("admin", "USER");
            accountServices.addRoleToUser("admin", "ADMIN");
            accountServices.addRoleToUser("user2", "USER");
            accountServices.addRoleToUser("user2", "CUSTOMER_MANAGER");
            accountServices.addRoleToUser("user3", "USER");
            accountServices.addRoleToUser("user3", "PRODUCT_MANAGER");
            accountServices.addRoleToUser("user4", "USER");
            accountServices.addRoleToUser("user4", "BILLS_MANAGER");

        };
    }
}

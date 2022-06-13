package diam.spring.springsecurity.Repositories;

import diam.spring.springsecurity.Entities.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRolesRepository extends JpaRepository<AppRoles, Long> {
    AppRoles findByRoleName(String roleName);
}

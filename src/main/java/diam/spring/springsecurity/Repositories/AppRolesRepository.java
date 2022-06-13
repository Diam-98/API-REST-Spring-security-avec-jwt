package diam.spring.springsecurity.Repositories;

import diam.spring.springsecurity.Entities.AppRoles;

public interface AppRolesRepository {
    AppRoles findByRoleName(String roleName);
}

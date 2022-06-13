package diam.spring.springsecurity.Repositories;

import diam.spring.springsecurity.Entities.AppUser;

public interface AppUserRepository {
    AppUser findByUserName(String userName);
}

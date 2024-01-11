package effectivemobile.taskmanagementsystem.service.impl;

import effectivemobile.taskmanagementsystem.entity.UserEntity;
import effectivemobile.taskmanagementsystem.exeptions.UserEmailNotFoundExeption;
import effectivemobile.taskmanagementsystem.repository.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepo userRepo;

    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UserEmailNotFoundExeption {
        UserEntity user = userRepo.findUserByEmail(email);
        if (user == null) {
            throw new UserEmailNotFoundExeption("email not found" + email);

        }
        return new User(user.getEmail(), user.getPassword(), Collections.emptyList());

    }
}

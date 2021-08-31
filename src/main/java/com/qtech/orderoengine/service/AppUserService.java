package com.qtech.orderoengine.service;

import com.qtech.orderoengine.mapper.AppUserMapper;
import com.qtech.orderoengine.model.entity.AppUser;
import com.qtech.orderoengine.model.request.AppUserRequest;
import com.qtech.orderoengine.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailValidator emailValidator;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }

    private AppUser saveAndReturn(AppUser appUser) {
        boolean userExists = appUserRepository
                .findByUsername(appUser.getUsername())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        return appUserRepository.save(appUser);
    }

    public AppUserRequest validateAndRegister(AppUserRequest appUserRequest) {
        boolean isValidEmail = emailValidator.test(appUserRequest.getUsername());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return AppUserMapper.toDto(saveAndReturn(AppUserMapper.fromDto(appUserRequest)));
    }

}

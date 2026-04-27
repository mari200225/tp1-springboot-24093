package com.supnum.tp_springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.supnum.tp_springboot.entities.AppUser;
import com.supnum.tp_springboot.repositories.AppUserRepository;
import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
 
    @Autowired
    private AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userInfo = repository.findByUsername(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
}
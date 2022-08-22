package com.softcaribbean.demo.services;

import com.softcaribbean.demo.models.UserModel;
import com.softcaribbean.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel getByName(String name) throws UsernameNotFoundException {
        ArrayList<UserModel> users = userRepository.findByName(name).get();
        if (users == null) {
            throw new UsernameNotFoundException("User: " + name + " was not found");
        }
        UserModel user = users.get(0);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        ArrayList<String> userRoles = user.getAllowedPages();
        userRoles.forEach(userRole -> {
            authorities.add(new SimpleGrantedAuthority(userRoles.toString()));
        });
        return user;
    }

}

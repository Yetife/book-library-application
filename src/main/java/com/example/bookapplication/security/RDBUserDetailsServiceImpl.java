package com.example.bookapplication.security;

import com.example.bookapplication.data.model.Authority;
import com.example.bookapplication.data.model.BookUser;
import com.example.bookapplication.data.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RDBUserDetailsServiceImpl implements UserDetailsService {

   @Autowired
    BookUserRepository bookUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BookUser user = bookUserRepository.findByEmail(username).orElse(null);
        if (user == null){
            throw new UsernameNotFoundException("User with email does not exist");
        }
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Authority> authorities) {
        return authorities.stream().map(authority -> {
            return new SimpleGrantedAuthority(authority.name());
        }).collect(Collectors.toList());
    }

}

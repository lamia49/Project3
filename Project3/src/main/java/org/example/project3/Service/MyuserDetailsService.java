package org.example.project3.Service;

import lombok.AllArgsConstructor;
import org.example.project3.Api.ApiException;
import org.example.project3.Model.Users;
import org.example.project3.Repositry.UserRepositry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyuserDetailsService implements UserDetailsService {
        private final UserRepositry authRepositry;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user= authRepositry.findUsersByUsername(username);
        if(user==null){
            throw new ApiException("Wrong");
        }
        return user;
    }
}

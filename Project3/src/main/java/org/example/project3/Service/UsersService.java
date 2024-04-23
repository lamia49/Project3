package org.example.project3.Service;

import lombok.RequiredArgsConstructor;
import org.example.project3.Api.ApiException;
import org.example.project3.DTO.CustomerDTO;
import org.example.project3.Model.Customer;
import org.example.project3.Model.Users;
import org.example.project3.Repositry.CoustmerRepositry;
import org.example.project3.Repositry.UserRepositry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
      private final UserRepositry userRepositry;



    public void login(String username ,String password){
       Users user = userRepositry.findUsersByUsernameAndPassword(username,password );
    }

    public void logout(){
    }






}

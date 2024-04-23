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
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
      private final UserRepositry userRepositry;
      private final CoustmerRepositry coustmerRepositry;
     public void registerCoustmer(CustomerDTO customerDTO){
         Users user=new Users();
         user.setUsername(customerDTO.getUsername());
         user.setName(customerDTO.getName());
         user.setEmail(customerDTO.getEmail());
         user.setPassword(customerDTO.getPassword());
         user.setRole("CUSTOMER");
     Customer customer=new Customer(null,customerDTO.getPhoneNumber(),null,null);
        String hashPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setCustomer(customer);
        customer.setUsers(user);
        coustmerRepositry.save(customer);
        userRepositry.save(user);
 }

 public List<Customer>AllCustmor(){
return coustmerRepositry.findAll();
 }

 public void updateCoustmer(String username,CustomerDTO customerDTO){
         Users user=userRepositry.findUsersByUsername(username);
         if (user==null){
             throw new ApiException("Not found");
         }
    user.setName(customerDTO.getName());
    user.setUsername(customerDTO.getUsername());
    user.setEmail(customerDTO.getEmail());
    user.setPassword(new BCryptPasswordEncoder().encode(customerDTO.getPassword()));
    Customer customer=coustmerRepositry.findCustomerByUsers(username);
    customer.setPhoneNumber(customerDTO.getPhoneNumber());
    userRepositry.save(user);
    coustmerRepositry.save(customer);
 }

  public void deleteCoustmer(Users user,String username){
           Users users=userRepositry.findUsersByUsername(username);
              if (user==null){
                  throw new ApiException("Not found");
             }
             userRepositry.delete(users);
         }



}

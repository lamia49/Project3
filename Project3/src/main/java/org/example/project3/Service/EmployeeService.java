package org.example.project3.Service;

import lombok.RequiredArgsConstructor;
import org.example.project3.Api.ApiException;
import org.example.project3.DTO.CustomerDTO;
import org.example.project3.DTO.EmpolyeeDTO;
import org.example.project3.Model.Customer;
import org.example.project3.Model.Employee;
import org.example.project3.Model.Users;
import org.example.project3.Repositry.EmployeeRepositry;
import org.example.project3.Repositry.UserRepositry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final UserRepositry userRepositry;
    private final EmployeeRepositry employeeRepositry;


         public void registerEmployee(EmpolyeeDTO empolyeeDTO){
         Users user=new Users();
         user.setUsername(empolyeeDTO.getUsername());
         user.setName(empolyeeDTO.getName());
         user.setEmail(empolyeeDTO.getEmail());
         user.setPassword(empolyeeDTO.getPassword());
         user.setRole("CUSTOMER");
             Employee employee=new Employee(null, empolyeeDTO.getPosition(),empolyeeDTO.getSalary(),null);
        String hashPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setEmployee(employee);
        employee.setUsers(user);
        employeeRepositry.save(employee);
        userRepositry.save(user);
 }

  public List<Employee> AllEmployee(){
return employeeRepositry.findAll();
 }


  public void updateEmployee(String username,EmpolyeeDTO empolyeeDTO){
         Users user=userRepositry.findUsersByUsername(username);
         if (user==null){
             throw new ApiException("Not found");
         }
    user.setName(empolyeeDTO.getName());
    user.setUsername(empolyeeDTO.getUsername());
    user.setEmail(empolyeeDTO.getEmail());
    user.setPassword(new BCryptPasswordEncoder().encode(empolyeeDTO.getPassword()));
     Employee employee=employeeRepositry.fideEmployeeByUserName(username);
      employee.setPosition(empolyeeDTO.getPosition());
      employee.setSalary(empolyeeDTO.getSalary());
    userRepositry.save(user);
  employeeRepositry.save(employee);
 }


 public void deleteEmployee(Users user,String username){
           Users users=userRepositry.findUsersByUsername(username);
              if (user==null){
                  throw new ApiException("Not found");
             }
             userRepositry.delete(users);
         }
}

package org.example.project3.Repositry;

import org.example.project3.Model.Customer;
import org.example.project3.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<Users,Integer> {
   Users findUsersByUsername(String username);
Users findUsersByUsernameAndPassword(String username , String password);
}

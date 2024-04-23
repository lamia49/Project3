package org.example.project3.Repositry;

import org.example.project3.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoustmerRepositry extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);
    @Query("select c from Customer c where c.users.username=?1")
    Customer findCustomerByUsers(String username);
}

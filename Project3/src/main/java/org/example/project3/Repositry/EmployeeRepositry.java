package org.example.project3.Repositry;

import org.example.project3.Model.Customer;
import org.example.project3.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee,Integer> {

    @Query("select employee from Employee employee where employee.users.username=?1")
    Employee fideEmployeeByUserName(String username);
}

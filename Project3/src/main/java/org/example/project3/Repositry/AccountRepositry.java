package org.example.project3.Repositry;

import org.example.project3.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositry extends JpaRepository<Account,Integer> {
       @Query("select a from Account a where a.id=?1")
    Account findAccountById(Integer id);
}

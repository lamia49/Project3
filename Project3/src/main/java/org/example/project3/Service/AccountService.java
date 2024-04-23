package org.example.project3.Service;

import lombok.AllArgsConstructor;
import org.example.project3.Api.ApiException;
import org.example.project3.Model.Account;
import org.example.project3.Model.Customer;
import org.example.project3.Model.Users;
import org.example.project3.Repositry.AccountRepositry;
import org.example.project3.Repositry.CoustmerRepositry;
import org.example.project3.Repositry.UserRepositry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountRepositry accountRepositry;
    private final UserRepositry userRepositry;
    private final CoustmerRepositry coustmerRepositry;

    public List<Account> getAllAccount() {
        return accountRepositry.findAll();
    }

    public void addAccount(Account account, Integer userId) {
        Customer customer=coustmerRepositry.findCustomerById(userId);
        account.setCustomer(customer);
        accountRepositry.save(account);
    }

    public void upadateAccount(Account account, Integer accountId, String username) {
        Users user = userRepositry.findUsersByUsername(username);
        Account account1 = accountRepositry.findAccountById(accountId);
        if (account1 == null) {
            throw new ApiException("Account id not found");
        } else if (account1.getCustomer().getId() == user.getCustomer().getId()) {
            account1.setAccountNumber(account.getAccountNumber());
            account1.setBalance(account.getBalance());
            accountRepositry.save(account);
        } else
            throw new ApiException("Not Allows");

    }

    public void deleteAccount(String username, Integer accountId) {
        Account account = accountRepositry.findAccountById(accountId);
        Users user1 = userRepositry.findUsersByUsername(username);
        if (user1.getCustomer().getId() == account.getCustomer().getId()) {
            accountRepositry.delete(account);
        } else
            throw new ApiException("Not Not Allows");
    }

    public void ActiveAccount(String username, Integer accountId) {
        Account account = accountRepositry.findAccountById(accountId);
        Users user1 = userRepositry.findUsersByUsername(username);
        if (user1.getRole().equals("ADMIN")) {
            account.setActive(true);
            accountRepositry.save(account);
        } else
            throw new ApiException("Not Not Allows");
    }

    public Account ViewDetails(String username,Integer accountId){
           Account account = accountRepositry.findAccountById(accountId);
        Users user1 = userRepositry.findUsersByUsername(username);
        if(account.getCustomer().getId()==user1.getCustomer().getId()){
              return  account ;
        }else
            return null;
    }


    public void deposit(String username,Integer accountId,Integer amount){
           Account account = accountRepositry.findAccountById(accountId);
        Users user1 = userRepositry.findUsersByUsername(username);
        if(account.getCustomer().getId()==user1.getCustomer().getId()){
            account.setBalance(account.getBalance()+amount);
            accountRepositry.save(account);
        }else
          throw new ApiException("Not Not Allows");
    }

        public void withdraw(String username,Integer accountId,Integer amount){
           Account account = accountRepositry.findAccountById(accountId);
        Users user1 = userRepositry.findUsersByUsername(username);
        if(account.getCustomer().getId()==user1.getCustomer().getId()){
            account.setBalance(account.getBalance()-amount);
            accountRepositry.save(account);
        }else
          throw new ApiException("Not Not Allows");
    }

    public void blockAccount(String username, Integer accountId){
           Account account = accountRepositry.findAccountById(accountId);
        Users user1 = userRepositry.findUsersByUsername(username);
        if (user1.getRole().equals("ADMIN")) {
            account.setActive(false);
            accountRepositry.save(account);
        } else
            throw new ApiException("Not Not Allows");
    }

    public void transTo(Integer fromAcountId,Integer toAccountID ,String username ,Integer amount ){
         Users user1 = userRepositry.findUsersByUsername(username);
        Account fromAcount = accountRepositry.findAccountById(fromAcountId);
        Account toAccount= accountRepositry.findAccountById(toAccountID);
          if(fromAcount.getCustomer().getId()==user1.getCustomer().getId()) {
              if (fromAcount.getBalance() >= amount) {
                  fromAcount.setBalance(fromAcount.getBalance() - amount);
                  toAccount.setBalance(toAccount.getBalance() + amount);
                  accountRepositry.save(fromAcount);
                  accountRepositry.save(toAccount);
              }
              throw new ApiException("Balance Not Enough!");
          }
          throw new ApiException("Not Allows");
    }


}

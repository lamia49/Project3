package org.example.project3.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.project3.Model.Account;
import org.example.project3.Model.Users;
import org.example.project3.Service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/v1/account/")
@RestController
public class AccountController {
    private final AccountService accountService;


      @GetMapping("/get-all")
    public ResponseEntity AllAccount(){
       return ResponseEntity.status(200).body(accountService.getAllAccount());
    }
      @PostMapping("/add")
    public ResponseEntity addAccount(@AuthenticationPrincipal Users user,@RequestBody @Valid Account account){
          accountService.addAccount(account,user.getId());
       return ResponseEntity.status(200).body("added successfully");
    }

        @PutMapping("/update/{accountId}")
    public ResponseEntity updateAccount( @AuthenticationPrincipal Users user,@PathVariable Integer accountId, @RequestBody @Valid Account account){
 accountService.upadateAccount(account,accountId,user.getUsername());
        return ResponseEntity.status(200).body("Updated successfully");
    }
            @DeleteMapping("/delete/{accountId}")
    public ResponseEntity deleteAccount(@AuthenticationPrincipal Users user, @PathVariable Integer accountId){
   accountService.deleteAccount(user,accountId);
        return ResponseEntity.status(200).body("delete successfully");
    }

            @PutMapping("/active/{accountId}")
    public ResponseEntity ActiveAccount( @AuthenticationPrincipal Users user,@PathVariable Integer accountId){
          accountService.ActiveAccount(user,accountId);
           return ResponseEntity.status(200).body("ACTIVE successfully");
    }

              @PutMapping("/block/{accountId}")
    public ResponseEntity BlockAccount( @AuthenticationPrincipal Users user,@PathVariable Integer accountId){
          accountService.blockAccount(user,accountId);
           return ResponseEntity.status(200).body("ACTIVE successfully");
    }

       @GetMapping("/view/{accountId}")
    public ResponseEntity ViewDetails(@AuthenticationPrincipal Users user,@PathVariable Integer accountId){
       return ResponseEntity.status(200).body(accountService.ViewDetails(user,accountId));
    }

          @PutMapping("/deposit/{accountId}/{amount}")
    public ResponseEntity Deposit( @AuthenticationPrincipal Users user,@PathVariable Integer accountId,@PathVariable Integer amount){
          accountService.deposit(user,accountId,amount);
           return ResponseEntity.status(200).body("Diposit successfully");
    }
             @PutMapping("/withdraw/{accountId}/{amount}")
    public ResponseEntity withdraw( @AuthenticationPrincipal Users user,@PathVariable Integer accountId,@PathVariable Integer amount){
          accountService.withdraw(user,accountId,amount);
           return ResponseEntity.status(200).body("withdraw successfully");
    }

    @PutMapping("/transTo/{fromaccountId}/{toaccountId}/{amount}")
    public ResponseEntity transTo( @AuthenticationPrincipal Users user,@PathVariable Integer fromaccountId,@PathVariable Integer toaccountId,@PathVariable Integer amount){
          accountService.transTo(fromaccountId,toaccountId,user,amount);
           return ResponseEntity.status(200).body("withdraw successfully");
    }

}

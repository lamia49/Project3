package org.example.project3.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.project3.DTO.CustomerDTO;
import org.example.project3.Model.Users;
import org.example.project3.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/v1/customer/")
@RestController
public class CustmoreController {
private  final CustomerService customerService;

  @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid CustomerDTO customerDTO){
   customerService.registerCoustmer(customerDTO);
        return ResponseEntity.status(200).body("registered successfully");
    }

    @GetMapping("/get-all")
    public ResponseEntity AllCoustmer(){
       return ResponseEntity.status(200).body(customerService.AllCustmor());
    }

      @PutMapping("/update")
    public ResponseEntity updateCoustmer( @AuthenticationPrincipal Users user, @RequestBody @Valid CustomerDTO customerDTO){
   customerService.updateCoustmer(user.getUsername(),customerDTO);
        return ResponseEntity.status(200).body("Updated successfully");
    }

             @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteCoustmer(@AuthenticationPrincipal Users user, @PathVariable String username){
   customerService.deleteCoustmer(user,username);
        return ResponseEntity.status(200).body("delete successfully");
    }



}

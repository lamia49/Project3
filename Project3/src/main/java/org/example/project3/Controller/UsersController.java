package org.example.project3.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.project3.DTO.CustomerDTO;
import org.example.project3.Model.Customer;
import org.example.project3.Model.Users;
import org.example.project3.Service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UsersController {
  private final UsersService userService;
 @PostMapping("/login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username ,@PathVariable String password){
        userService.login(username ,password);
        return ResponseEntity.status(200).body("login successfully");
    }

         @PostMapping("/logout/{username}/{password}")
    public ResponseEntity logout(){
        userService.logout();
        return ResponseEntity.status(200).body("logout successfully");
    }


}

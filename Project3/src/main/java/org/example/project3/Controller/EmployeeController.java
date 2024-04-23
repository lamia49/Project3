package org.example.project3.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.project3.DTO.CustomerDTO;
import org.example.project3.DTO.EmpolyeeDTO;
import org.example.project3.Model.Users;
import org.example.project3.Repositry.EmployeeRepositry;
import org.example.project3.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api/v1/employee/")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

      @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid EmpolyeeDTO empolyeeDTO){
   employeeService.registerEmployee(empolyeeDTO);
        return ResponseEntity.status(200).body("registered successfully");
    }


       @GetMapping("/get-all")
    public ResponseEntity AllEmployee(){
       return ResponseEntity.status(200).body(employeeService.AllEmployee());
    }

         @PutMapping("/update")
    public ResponseEntity updateEmployee(@AuthenticationPrincipal Users user, @RequestBody @Valid EmpolyeeDTO empolyeeDTO){
   employeeService.updateEmployee(user.getUsername(),empolyeeDTO);
        return ResponseEntity.status(200).body("Updated successfully");
    }

         @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteEmployee(@AuthenticationPrincipal Users user, @PathVariable String username){
   employeeService.deleteEmployee(user,username);
        return ResponseEntity.status(200).body("delete successfully");
    }

}

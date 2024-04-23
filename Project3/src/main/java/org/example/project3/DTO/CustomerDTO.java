package org.example.project3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    //@Pattern(regexp = "^05.*",message = "the salary must me not empty")
//    @NotNull(message = "phoneNumber must be not empty")
     private String phoneNumber;
//              @NotEmpty(message = "username must be not empty")
//      @Min(4)
//      @Max(6)
      private String username;
//      @NotEmpty(message = "password must be not null")
//      @Min(6)
      private String password;
//       @Min(2)
      private String name;
//       @Email(message = "email must be valid email")
       private String email;

}

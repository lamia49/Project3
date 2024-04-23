package org.example.project3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpolyeeDTO {
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
    @NotEmpty(message = "postion cannot be empty")
    private String position;
@NotNull(message = "salary cann,t be empty")
//@Pattern(regexp = "^05.*",message = "the salary must me not empty")
private Integer salary;
}

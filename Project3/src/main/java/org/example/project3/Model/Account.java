package org.example.project3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
          @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//@Pattern(regexp = "\\d{4}-\\d{4}-\\d{4}-\\d{4}", message = "Account number must follow the format XXXX-XXXX-XXXX-XXXX.")
    @Column(columnDefinition = "int not null ")
//    @NotNull(message = "account number must be not empty")
     private Integer accountNumber;
    @Column(columnDefinition = "int not null")
//@DecimalMin(value = "0.0",inclusive = true)
     private Integer balance;
//    @AssertFalse
   private boolean isActive;
    @ManyToOne
    @JsonIgnore
    private Customer customer;
}

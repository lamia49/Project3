package org.example.project3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
      @Id
    private Integer id;
      //@Pattern(regexp = "^05.*",message = "the salary must me not empty")
//    @NotNull(message = "phoneNumber must be not empty")
     @Column(columnDefinition = "varchar(50)")
     private String phoneNumber;
     @OneToOne
    @MapsId
    @JsonIgnore
private Users users;
     @OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
 private Set<Account> accouns;

}

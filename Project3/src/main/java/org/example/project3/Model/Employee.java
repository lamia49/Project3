package org.example.project3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
   @Id
    private Integer id;
//@NotEmpty(message = "postion cannot be empty")
 @Column(columnDefinition = "varchar(20)")
    private String position;
//@NotNull(message = "salary cann,t be empty")
//@Pattern(regexp = "^05.*",message = "the salary must me not empty")
 @Column(columnDefinition = "int")
private Integer salary;
 @OneToOne
    @MapsId
    @JsonIgnore
private Users users;

}

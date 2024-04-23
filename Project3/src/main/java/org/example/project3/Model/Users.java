package org.example.project3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users implements UserDetails {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//      @NotEmpty(message = "username must be not empty")
//      @Min(4)
//      @Max(6)
      @Column(columnDefinition = "varchar(10) unique")
      private String username;
//      @NotEmpty(message = "password must be not null")
//      @Min(6)
       @Column(columnDefinition = "varchar(250)")
      private String password;
       @Column(columnDefinition = "varchar(22)")
//       @Min(2)
      private String name;
//       @Email(message = "email must be valid email")
       @Column(columnDefinition = "varchar(50) unique ")
       private String email;
//    @Pattern(regexp = "^(CUSTOMER|EMPLOYEE|ADMIN)")
     @Column(columnDefinition = "varchar(50) ")
       private String role;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "users")
    @PrimaryKeyJoinColumn
    private Employee employee;




   @OneToOne(cascade = CascadeType.ALL,mappedBy = "users")
    @PrimaryKeyJoinColumn
    private Customer customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
     return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

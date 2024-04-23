package org.example.project3.SecurityConfig;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.project3.Service.MyuserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {

    private final MyuserDetailsService myuserDetailsService;
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myuserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }
   @Bean
       public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(daoAuthenticationProvider())
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/customer/register").permitAll()   //HttpMethod.POST ,  //**All ,
               .requestMatchers("/api/v1/employee/register").permitAll()
            .requestMatchers("/api/v1/employee/get-all").hasAuthority("ADMIN")
            .requestMatchers("/api/v1/customer/get-all").hasAuthority("ADMIN")
            .requestMatchers("/api/v1/customer/update").hasAuthority("CUSTOMER")
             .requestMatchers("/api/v1/employee/update").hasAuthority("EMPLOYEE")
            .requestMatchers("/api/v1/employee/delete/**").hasAuthority("ADMIN")
            .requestMatchers("/api/v1/account/get-all").hasAuthority("ADMIN")
            .requestMatchers("/api/v1/account/add").hasAuthority("CUSTOMER")
            .requestMatchers("api/v1/account/delete/**").hasAuthority("CUSTOMER")
            .requestMatchers("api/v1/account/active/**").hasAuthority("ADMIN")
            .requestMatchers("/api/v1/account/view/**").hasAuthority("CUSTOMER")
            .requestMatchers("/api/v1/account/deposit/**").hasAuthority("CUSTOMER")
            .requestMatchers("/api/v1/account/withdraw/**").hasAuthority("CUSTOMER")
            .requestMatchers("/api/v1/account/block/**").hasAuthority("ADMIN")
            .requestMatchers("api/v1/account/transTo/**").hasAuthority("CUSTOMER")
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
        return http.build();


    }
}

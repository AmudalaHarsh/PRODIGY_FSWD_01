package com.task.secureuser.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigClass {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
             return http
                     .csrf(csrf->csrf.disable())
                .authorizeHttpRequests((auth-> auth
                .requestMatchers("/","/css/**","/login","/logout").permitAll()
                        .requestMatchers(HttpMethod.POST, "/register").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()))
                     .formLogin(form-> form
                             .loginPage("/login")
                             .successHandler( new MyAuthenticationSuccessHandler())
                             .failureUrl("/login?error=true")
                             .permitAll())
                     .logout(logout -> logout
                             .logoutUrl("/logout")
                             .logoutSuccessUrl("/login?logout")
                     .permitAll())
                .build();
    }
}

package com.merqury.mysite.config;

import com.merqury.mysite.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/", "/login", "/logout").permitAll()
                .requestMatchers(HttpMethod.GET, "/prod/**").hasAnyAuthority(Role.ROLE_ADMIN.name(), Role.ROLE_USER.name(), Role.ROLE_MODER.name())
                .requestMatchers(HttpMethod.POST, "/prod/**").hasAnyAuthority(Role.ROLE_ADMIN.name(), Role.ROLE_MODER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .authorities(Role.ROLE_ADMIN)
                        .build(),
                User.builder()
                        .username("usr")
                        .password(passwordEncoder().encode("user"))
                        .authorities(Role.ROLE_USER)
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}

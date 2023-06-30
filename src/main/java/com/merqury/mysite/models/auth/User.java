package com.merqury.mysite.models.auth;

import com.merqury.mysite.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "active")
    private boolean active;
    @Column(name = "date_of_create")
    private LocalDateTime createDateTime;
    @Column(name = "role")
    private Role role;
}

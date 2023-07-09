package com.merqury.mysite.services;

import com.merqury.mysite.models.auth.User;
import com.merqury.mysite.repositories.UserRepository;
import com.merqury.mysite.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("userService")
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;


    public User getByToken(String token){
        return repository.findByToken(token).orElse(null);
    }

    public String getToken(String email, String password){
        User user = repository.findByEmail(email).orElse(null);
        if(user == null)
            return null;

        if(!encoder.matches(password, user.getPassword()))
            return null;

        return user.getToken();
    }

    public boolean register(String username, String email, String password){
        if(repository.findByEmail(email).orElse(null) != null)
            return false;
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setToken(encoder.encode(String.format("%s:%s", email, password)));
        repository.save(user);
        return true;
    }
}

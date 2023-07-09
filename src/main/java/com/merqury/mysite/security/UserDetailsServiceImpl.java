package com.merqury.mysite.security;

import com.merqury.mysite.models.auth.User;
import com.merqury.mysite.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("USER EXCEPTION"));
        return SecurityUser.fromOurUser(user);
    }

    public User getByToken(String token){
        return repository.findByToken(token).orElse(null);
    }

    public String getToken(String email, String password){
        User user = repository.findByEmail(email).orElse(null);
        if(user == null)
            return null;

        if(encoder.matches(password, user.getPassword()))
            return null;

        return user.getToken();
    }
}

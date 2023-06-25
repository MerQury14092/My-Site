package com.merqury.mysite.services;

import com.merqury.mysite.models.User;
import com.merqury.mysite.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private MessageDigest digest;

    {
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User user){
        repository.save(new User(user.getUsername(), user.getEmail(), hash(user.getPassword())));
    }

    public void rmUser(long id){
        repository.deleteById(id);
    }

    public User getUser(long id){
        return repository.findById(id).orElse(null);
    }

    public User validate(String email, String password){
        List<User> users = repository.findByEmail(email);
        User tmp;
        if(users.size() < 1)
            return null;
        else
            tmp = users.get(0);

        if(!hash(password).equals(tmp.getPassword()))
            return null;
        return tmp;
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public String hash(String pass){
        byte[] encodedBytes = digest.digest(pass.getBytes());
        return bytesToHex(encodedBytes);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

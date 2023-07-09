package com.merqury.mysite.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    private final MessageDigest digest;

    public PasswordEncoder() {
        try {
            this.digest = MessageDigest.getInstance("SHA-224");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String encode(String text){
        byte[] bytes = text.getBytes(StandardCharsets.US_ASCII);
        byte[] encodedBytes = digest.digest(bytes);

        for (int i = 0; i < encodedBytes.length; i++) {
            encodedBytes[i] = (byte) (48 + (Math.abs(encodedBytes[i]) % (122 - 48)));
            if(encodedBytes[i] >= 58 && encodedBytes[i] <= 64)
                encodedBytes[i] = 81;

            if(encodedBytes[i] >= 91 && encodedBytes[i] <= 96)
                encodedBytes[i] = 109;

        }

        return new String(encodedBytes, StandardCharsets.US_ASCII);
    }

    public boolean matches(String rawString, String encodedString){
        return encode(rawString).equals(encodedString);
    }
}

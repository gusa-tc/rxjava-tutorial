package com.example.model;

import lombok.NonNull;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptPasswordVault implements PasswordVault {

    public static final int DEFAULT_SALT_ROUNDS = 10;
    private String hashed;
    private final int saltRounds;

    public BCryptPasswordVault() {
        this(DEFAULT_SALT_ROUNDS);
    }

    public BCryptPasswordVault(int saltRounds) {
        this.saltRounds = saltRounds;
    }

    @Override
    public String getPassword() {
        return hashed;
    }

    @Override
    public void setPassword(@NonNull String plaintext) {
        try {
            BCrypt.checkpw(BCrypt.gensalt(5), plaintext);
            hashed = plaintext;
        } catch (IllegalArgumentException e) {
            hashed = BCrypt.hashpw(plaintext, BCrypt.gensalt(saltRounds));
        }
    }

    @Override
    public boolean isValidPassword(String plaintext) {
        try {
            return BCrypt.checkpw(plaintext, hashed);
        } catch (Throwable t) {
            return false;
        }
    }
}

package com.example.model;

public interface PasswordVault {
    void setPassword(String plaintext);

    String getPassword();

    boolean isValidPassword(String plaintext);
}

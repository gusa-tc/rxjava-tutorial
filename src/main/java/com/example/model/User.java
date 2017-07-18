package com.example.model;

import lombok.Data;

@Data
public class User implements PasswordVault{
    public static final String DEFAULT_PASSWORD = "_Passw0rd$1";
    private final String userName;
    private final PasswordVault passwordVault;
    private UserRole userRole;

    public User(String userName, String password, UserRole userRole) {
        this.userName = userName;
        this.userRole = userRole;
        this.passwordVault = new BCryptPasswordVault();
        setPassword(password);
    }

    public User(String userName) {
        this(userName, DEFAULT_PASSWORD, UserRole.GUEST);
    }

    public String getUserName() {
        return userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public void setPassword(String plaintext) {
        passwordVault.setPassword(plaintext);
    }

    @Override
    public String getPassword() {
        return passwordVault.getPassword();
    }

    @Override
    public boolean isValidPassword(String plaintext) {
        return passwordVault.isValidPassword(plaintext);
    }
}

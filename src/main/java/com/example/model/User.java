package com.example.model;

import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

@Data
public class User {
    public static final String DEFAULT_PASSWORD = "_Passw0rd$1";
    private final String userName;
    private String password;
    private UserRole userRole;

    public User(String userName, String password, UserRole userRole) {
        this.userName = userName;
        this.userRole = userRole;
        setPassword(password);
    }

    public User(String userName) {
        this(userName, DEFAULT_PASSWORD, UserRole.GUEST);
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean isPasswordValid(String password) {
        return BCrypt.checkpw(password, this.password);
    }


    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}

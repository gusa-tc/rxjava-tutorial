package com.example.model;

import java.util.function.Function;

public enum UserRole {
    GUEST(0), USER(10), ADMIN(100), SUPERADMIN(1000);

    private final int id;

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private static Function<Integer, UserRole> roleFromId = id -> {
        switch (id) {
            case 10:
                return USER;
            case 100:
                return ADMIN;
            case 1000:
                return SUPERADMIN;
            default:
                return GUEST;
        }
    };
}

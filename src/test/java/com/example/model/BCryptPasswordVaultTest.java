package com.example.model;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.Assert.*;

public class BCryptPasswordVaultTest {

    @Test
    public void shouldGetAndSetPassword() throws Exception {
        BCryptPasswordVault vault = new BCryptPasswordVault();
        vault.setPassword("123");
        assertNotEquals("123", vault.getPassword());
        assertTrue(vault.isValidPassword("123"));
    }

    @Test
    public void shouldSetHashedPassword() throws Exception {
        BCryptPasswordVault vault = new BCryptPasswordVault();
        vault.setPassword(BCrypt.hashpw("234", BCrypt.gensalt()));
        assertNotEquals("234", vault.getPassword());
        assertTrue(vault.isValidPassword("234"));

    }
}
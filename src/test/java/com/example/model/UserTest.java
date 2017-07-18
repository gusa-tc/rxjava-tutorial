package com.example.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Anton on 18.07.2017.
 */
public class UserTest {

    public static final String SECRET_PASSWORD = "kXkazWC#u8z*Paq'";
    public static final String SECRET_PASSWORD2 = "3+ExJh2HywLS!dhQ";

    @Test
    public void shouldStoreAndValidatePassword() throws Exception {
        User test = new User("Panda", SECRET_PASSWORD, UserRole.ADMIN);
        assertEquals("Panda", test.getUserName());
        assertEquals(UserRole.ADMIN, test.getUserRole());
        assertFalse(test.isPasswordValid(User.DEFAULT_PASSWORD));
        assertTrue(test.isPasswordValid(SECRET_PASSWORD));
    }


    @Test
    public void shouldChangePassword() throws Exception {
        User test = new User("Jennifer", SECRET_PASSWORD, UserRole.ADMIN);
        assertEquals("Jennifer", test.getUserName());
        assertEquals(UserRole.ADMIN, test.getUserRole());
        assertFalse(test.isPasswordValid(User.DEFAULT_PASSWORD));
        assertTrue(test.isPasswordValid(SECRET_PASSWORD));
        test.setPassword(SECRET_PASSWORD2);
        assertFalse(test.isPasswordValid(SECRET_PASSWORD));
        assertTrue(test.isPasswordValid(SECRET_PASSWORD2));
    }


    @Test
    public void shouldCreateGuest() throws Exception {

        User test = new User("Alan");

        assertEquals("Alan", test.getUserName());
        assertEquals(UserRole.GUEST, test.getUserRole());
        assertTrue(test.isPasswordValid(User.DEFAULT_PASSWORD));

    }
}
package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testWelcomeMessage() {

        String result = App.getWelcomeMessage("Sai");

        assertEquals("Welcome, Sai!", result);
    }

    @Test
    public void testAnotherUser() {

        String result = App.getWelcomeMessage("John");

        assertEquals("Welcome, John!", result);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package PoeClasses;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author user
 */
public class PoeTest {
    
    public PoeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @Test
    public void testValidUsername() {
        assertTrue(poe.isValidUsername("kyl_1"));
    }
    
    @Test
    public void testInvalidUsername() {
        assertFalse(poe.isValidPassword("kyle!!!!!!!"));
    }
    
    @Test
    public void testValidPassword() {
        assertTrue(poe.isValidPassword("password"));
    }
    
    @Test
    public void InvalidPasswordShort() {
        assertFalse(poe.isValidPassword("Ch&&sec@ke99!"));
    }
    
    @Test 
    public void testInvalidPasswordNoSpecialChart() {
        assertFalse(poe.isValidPassword("Chsecke99"));
    }
    
    @Test
    public void testValidCellPhone() {
        assertTrue (poe.checkCellPhone("+27838968976"));
    }
    
    @Test
    public void testInvalidCellPhone() {
        assertFalse(poe.checkCellPhone("08966553"));
    }
}

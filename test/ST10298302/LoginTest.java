/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ST10298302;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

/**
 *
 * @author kylen
 */
public class LoginTest
{

    String username, password;
    Login logTest = new Login("kyl_1", "Ch&&sec@ke99!", "Kyle", "Nel");

    @Test
    public void testLoginUser()
    {
        username = "kyl_1";
        password = "Ch&&sec@ke99!";
        logTest.setUsername(username);
        logTest.setPassword(password);
        assertTrue(username.equals(logTest.getUsername()) && password.equals(logTest.getPassword()));
        username = "kyle!!!!!!!!";
        password = "Password";
        assertFalse(username.equals(logTest.getUsername()) && password.equals(logTest.getPassword()));
    }

    @Test
    public void testCheckUserName()
    {
        String expectedUsername = "kyl_1", actualUser = logTest.getUsername();

        assertEquals(expectedUsername, actualUser, "Username is not correctly formatted");
        assertTrue(logTest.checkUserName());
        logTest.setUsername("Kyle!!!!!");
        assertFalse(logTest.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity()
    {
        String expectedPassword = "Ch&&sec@ke99!", actualPass = logTest.getPassword();
        assertEquals(expectedPassword, actualPass, "Password is not correctly formatted");
        assertTrue(logTest.checkPasswordComplexity());
        logTest.setPassword("pass");
        assertFalse(logTest.checkPasswordComplexity());
    }

}

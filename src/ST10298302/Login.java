/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ST10298302;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author kylen
 */
public class Login
{

    private String username = "", password = "", firstName = "", lastName = ""; //Declaring the variables 
    private boolean validU = false, validP = false; //Declaring the booleans


    public Login(String user, String pass, String firstName, String lastName) // The constructor 
    {
        this.username = user;
        this.password = pass;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setUsername(String username) // Set username method
    {
        this.username = username;
    }

    public void setPassword(String password) //set password method
    {
        this.password = password;
    }

    public String getUsername() // get username method
    {
        return username;
    }

    public String getPassword() // get password method
    {
        return password;
    }

    public boolean loginUser() // Login user method
    {
        String user, pass; // Declaring the strings for new username and password
        boolean valid = false; // The flag
        JOptionPane.showMessageDialog(null, "Please enter your details to login"); //  Message to let the user login
        user = JOptionPane.showInputDialog("Enter your username"); // Enter the new username
        pass = JOptionPane.showInputDialog("Enter your password"); // Enter the new password
        while (valid == false)  // While loop if flag is false
        {
            validU = false;// Flag for the valid username 
            if (user.equals(username) && pass.equals(password)) // Testing if the password and username is true or false
            {
                JOptionPane.showMessageDialog(null, "Welcome " + firstName + "," + lastName + " it is great to see you again."); // if true return this messager
                valid = true; // set the flag to true
                System.out.println(returnLoginStatus(valid)); // Print out the status
            } else
            {
                valid = false; // Set the flag to false
                System.out.println(returnLoginStatus(valid)); // Print out the status
                JOptionPane.showMessageDialog(null, "Username or password is incorrect please try again"); // Tells you the password or username is incorrect
                user = JOptionPane.showInputDialog("Please re-enter your username."); // Enter your username again
                pass = JOptionPane.showInputDialog("Please re-enter you password."); // Enter your password again
            }
        }

        return valid; // return the flag
    }

    public String returnLoginStatus(boolean valid) // Login status method
    {
        String status = "";

        if (valid == true) // If true
        {
            status = "A succesful login"; // return successful
        } else if (valid == false) // if false
        {
            status = "A failed login"; // Return Failed
        }
        return status;
    }

    public boolean checkUserName() // Check username method
    {
        return (username.length() <= 5 && username.contains("_"));
    }

    public boolean checkPasswordComplexity() // Password complexity method
    {
        boolean length, digit, upper, special; // Declaring boolean variables
        Pattern pat = Pattern.compile("[a-zA-Z0-9]*"); // Setting the pattern for special characters

        Matcher match = pat.matcher(password); // Testing the matche to the password
        length = false; //Setting all the variables false
        digit = false;
        upper = false;
        special = false;
        for (int i = 0; i < password.length(); i++) // For loop to run through the length of the string
        {
            char letter;// Declaring the char for 
            letter = password.charAt(i); // Setting the char to the letter in the string
            
            
            if (Character.isDigit(letter)) // If it is a digit
            {
                digit = true; // Sets it to true
            }
            if (Character.isUpperCase(letter)) // If it is a uppercase
            {
                upper = true; // Sets it to true
            }
            if (!match.matches()) // If the match is false there is a special character
            {
                special = true; // Sets it to true
            }
            if (password.length() >= 8) // Checks the password length is longer than 
            {
                length = true; // Sets it to true
            }
        }
        return (digit && upper && special && length);// Tests

    }

    public String registerUser() // Register user method
    {
        boolean checkU = false, checkP = false;
        while (checkU == false)
        {

            if (checkUserName() == true)
            {
                validU = true; // Setting the valid username to true
                checkU = true; // Setting the check username to true
                JOptionPane.showMessageDialog(null, "Username successfully captured"); //Displaying a message to the user
            } else
            {
                validU = false; // Setting the valid username to false
                checkU = false;// Setting the check username to false
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted,\n" + "please ensure that your username contains\n" + "an underscore and is no more than\n" + "5 characters in length ."); // Showing the message
                username = JOptionPane.showInputDialog("Please re-enter your username"); // Asking for the username again
                setUsername(username); // Setting the username
            }
        }
        while (checkP == false)
        {
            if (checkPasswordComplexity())
            {
                validP = true; // Setting the valid password to true
                checkP = true; // Setting the check password to true
                JOptionPane.showMessageDialog(null, "Password successfully captured");
            } else
            {
                validP = false; // Setting the valid password to false
                checkP = false; // Setting the check password to false
                JOptionPane.showMessageDialog(null, "Password is not\n" + "correctly formatted,\n" + "please ensure that\n" + "the password\n" + "contains at least 8\n" + "characters, a capital\n" + "letter, a number and\n" + "a special character."); // Displays the message again
                password = JOptionPane.showInputDialog("Please re-enter your password"); // asking for the password again
                setPassword(password); // Setting the password again
            }
        }

        String status = ""; // Declaring the status message

        if (validU == true && validP == true) // Testing if both the username and password is valid
        {
            status = "Successfully registered"; // Sets the status to successful
        } else
        {

            status = "Failed to register"; // Sets the status to failed
        }
        return status; // return the status
    }
}

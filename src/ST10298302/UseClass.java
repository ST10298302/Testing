/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ST10298302;

import javax.swing.JOptionPane;

/**
 *
 * @author kylen
 */
public class UseClass
{

    private String username = "", password = "", firstName = "", lastName = "";
    private Login log = new Login(username, password, firstName, lastName); // Delcaring the object
    private Task tLog= new Task(firstName, lastName);
    public UseClass()
    {
//        username = JOptionPane.showInputDialog("Enter your username"); // Asking fior the username
//        log.setUsername(username); // Setting the username in the backend
//        password = JOptionPane.showInputDialog("Enter your password");// Asking for the password
//        log.setPassword(password);// Setting the password in the backend
//        firstName = JOptionPane.showInputDialog("Enter your first name"); // Asking for their first name
//        lastName = JOptionPane.showInputDialog("Enter your last name"); // Asking for their last name
//        log.registerUser(); // Testing the methods for the validation
//        log = new Login(log.getUsername(), log.getPassword(), firstName, lastName); // Decalring the object, with all variables 
//        log.loginUser();// Running the login user method from the backend
        tLog.setFirst("Kyle");
        tLog.setLast("Nel");
        tLog.runTask();
    }

    public static void main(String[] args)
    {
        new UseClass();

    }

}

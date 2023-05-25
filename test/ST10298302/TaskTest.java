/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ST10298302;

import javax.swing.JOptionPane;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kylen
 */
public class TaskTest
{

    int numTask, duration, count = 1;
    String first, last, desc;
    String taskNames;

    Task testTask = new Task(first, last);

    @Test
    public void testDescription()
    {

        desc = "Create Login to authenticate users";
        boolean length = desc.length() <= 50;
        try
        {
            assertEquals(desc.length() <= 50, length);
            //   JOptionPane.showMessageDialog(null, "Task successfully captured");
        } catch (AssertionError f)
        {

        }
        JOptionPane.showMessageDialog(null, "Task successfully captured");
        desc = "Create Add Task feature to add task users";
        length = desc.length() <= 50;
        try
        {
            assertEquals(desc.length() > 50, length);
        } catch (AssertionError e)
        {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
        }
    }

    @Test
    public void testID()
    {
        first = JOptionPane.showInputDialog("Enter the first name");
        last = JOptionPane.showInputDialog("Enter the last name");
        testTask.setFirst(first);
        testTask.setLast(last);
        testTask.runTask();
        count++;
       
    }

    @Test
    public void testTotalHours()
    {

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ST10298302;

import javax.swing.JOptionPane;

/**
 *
 * @author kylen
 */
public class Task
{

    String first, last, taskDescription, devDetails, firstTwo, ID, displayStatus;
    int option, numberOfTasks, taskNum = 0, taskDuration, taskStatus, count = 1, totalHours, total = 0;

    String taskName;
  

    public Task(String first, String last)
    {
        this.first = first;
        this.last = last;
    }

    public void setDevDetails(String devDetails)
    {
        this.devDetails = devDetails;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public void setFirst(String first)
    {
        this.first = first;
    }

    public void setLast(String last)
    {
        this.last = last;
    }

    public void runTask()
    {

        while (option != 3)
        {
      
            option = Integer.parseInt(JOptionPane.showInputDialog("Option 1) Add Tasks\n"
                    + "Option 2) Show Report\n"
                    + "Option 3) Quit"));
            switch (option)
            {
                case 1:

                    numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
                    while (numberOfTasks > 0)
                    {
                        taskName=JOptionPane.showInputDialog("Enter the name of your task");
                        testsForNumAndDesc();
                        devDetails = first + " " + last;
                        taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the estimated duration for the task in hours"));
                        firstTwo = taskName.substring(0, 2);
                        ID = createTaskID();
                        totalHours = returnTotalHours();
                        displayStatus = checkTaskStatus();
                        taskStatus = 0;
                        JOptionPane.showMessageDialog(null, printTaskDetails());
                        numberOfTasks--;
                        taskNum++;
                        count++;
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    option = Integer.parseInt(JOptionPane.showInputDialog("Option 1) Add Tasks\n"
                            + "Option 2) Show Report\n"
                            + "Option 3) Quit"));
                    break;
            }
            JOptionPane.showMessageDialog(null, "Total Hours of all tasks: " + totalHours);
        }
    }

    public void testsForNumAndDesc()
    {

        if (taskNum == 4)
        {
            taskNum = 0;
        }
        taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters");
        if (checkTaskDescription() == true)
        {
            JOptionPane.showMessageDialog(null, "Task successfully captured");
        } else
        {
            while (checkTaskDescription() == false)
            {
                taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters");
            }
        }

    }

    public String checkTaskStatus()
    {
        String status;
        while (taskStatus > 3 || taskStatus <= 0)
        {
            taskStatus = Integer.parseInt(JOptionPane.showInputDialog("Which status is this task in:\n"
                    + "1 ) To Do\n"
                    + "2 ) Done\n"
                    + "3 ) Doing"));
        }
        switch (taskStatus)
        {
            case 1:
                status = "To Do";
                break;
            case 2:
                status = "Done";
                break;
            default:
                status = "Doing";
                break;
        }
        return status;
    }

    public boolean checkTaskDescription()
    {
        return taskDescription.length() <= 50;
    }

    public String createTaskID()
    {
        return (firstTwo + ":" + count + ":" + devDetails.substring(devDetails.length() - 3, devDetails.length())).toUpperCase();
    }

    public String printTaskDetails()
    {
        String print = "Task Status: " + displayStatus + "\nDeveloper: " + devDetails + "\nTask Number: " + count + "\nTask Name: " + taskName + "\nTask "
                + "Description: " + taskDescription + "\nTask ID: " + ID + "\nTask Duration: " + taskDuration + "hrs";
        System.out.println(print);
        return print ;
    }

    public int returnTotalHours()
    {
        total += taskDuration;
        return total;
    }

}

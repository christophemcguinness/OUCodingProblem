/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicedesk;

import java.util.Scanner;

/**
 *
 * @author chrismcguinness
 */
public class EmployeeFactory {

    public Employee LoginEmployee()
    {
        Employee employee = null;

        String name;
        String email;
        int employeeID;

        Scanner myScanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("\n---- Login Screen ----.\n");
        
        System.out.println("Input your Employee Name:\n");
        name = myScanner.nextLine(); 

        System.out.println("Input your Email:\n");
        email = myScanner.nextLine(); 
        
        //set employeeId
        employeeID = GetEmployeeID(myScanner);

        employee = SetEmployeeObject(myScanner,name,email,employeeID);

        return employee;
    }

    private int GetEmployeeID(Scanner myScanner)
    {
        int employeeId = 0;

        try
        {
            System.out.println("Input your Employee Id:\n");
            employeeId = Integer.parseInt(myScanner.nextLine());
        }catch  (NumberFormatException e)
        {
            System.out.println("Not a Valid employee id please only input digits");
            GetEmployeeID(myScanner);

        }

        return employeeId;
    }

    private Employee SetEmployeeObject(Scanner myScanner,String name,String email, int employeeId)
    {
        int employeeType = 0;
        Employee employee = null;

        try
        {
            System.out.println("Input your type:\n");
            System.out.println("1. Admin\n");
            System.out.println("2. Support\n");
            System.out.println("3. Manager\n");
            System.out.println("4. Basic\n");
            employeeType = Integer.parseInt(myScanner.nextLine());

            if(employeeType == 1)
                    {
                        employee = new Admin(name, email, employeeId);
                    }else if (employeeType == 2) 
                    {
                        employee = new Support(name, email, employeeId);            
                    }else if (employeeType == 3) 
                    {
                        employee = new Manager(name, email, employeeId);            
                    }else if (employeeType == 4) 
                    {
                        employee = new BasicEmployee(name, email, employeeId);            
                    }

        }catch  (NumberFormatException e)
        {
            System.out.println("Not a valid employee type please only input digits");
            employee = SetEmployeeObject(myScanner, name, email, employeeId);

        }

        

        return employee;
    }

    
}

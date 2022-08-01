package servicedesk;

import java.util.List;

public class ServiceDesk {


    public static void main(String[] args) {

    //Workflow 1
    EmployeeFactory employeeFactory = new EmployeeFactory();
    Employee user = employeeFactory.LoginEmployee();

        System.out.println("Is Admin: "+user.isAdmin());
        System.out.println("Is Support: "+user.isSupport());
        System.out.println("Is Manager: "+user.isManager());

    Pot pot = new Pot(1, "Service Desk Main Pot", user);    
    pot.viewCalls();




    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicedesk;

/**
 *
 * @author chrismcguinness
 */
public class BasicEmployee extends Employee {

    public BasicEmployee(String name,String email,int employeeId) {
    this.setName(name);
    this.setEmail(email);
    this.setEmployeeId(employeeId);
    this.setIsSupport(false);
    this.setIsAdmin(false);
    this.setIsManager(false);

    }

}

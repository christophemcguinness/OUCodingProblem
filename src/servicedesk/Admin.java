/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicedesk;

/**
 *
 * @author chrismcguinness
 */
public class Admin extends Employee {

    public Admin(String name,String email,int employeeId) {
    this.setName(name);
    this.setEmail(email);
    this.setEmployeeId(employeeId);
    this.setIsSupport(true);
    this.setIsAdmin(true);
    this.setIsManager(false);

    }

}

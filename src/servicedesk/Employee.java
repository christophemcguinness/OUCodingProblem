/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicedesk;

/**
 *
 * @author chrismcguinness
 */
public abstract class Employee {
    private String name;
    private String email;
    private int employeeId;
    private boolean isSupport;
    private boolean isAdmin;
    private boolean isManager;
    

    public String getName() {return name;}
    public String getEmail() {return email;}
    public int getEmployeeId() {return employeeId;}
    
    public Boolean isSupport() {return isSupport;}
    public Boolean isAdmin() {return isAdmin;}
    public Boolean isManager() {return isManager;}
    
    public void setIsSupport(boolean supportBool) {this.isSupport = supportBool;}
    public void setIsAdmin(boolean adminBool) {this.isAdmin = adminBool;}
    public void setIsManager(boolean managerBool) {this.isManager = managerBool;}
    
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setEmployeeId(int employeeId) {this.employeeId = employeeId;}
}

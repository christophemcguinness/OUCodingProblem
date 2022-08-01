/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicedesk;

import java.time.LocalDate;

/**
 *
 * @author chrismcguinness
 */
public class Log {

private String message;
private LocalDate dateTime;

    public Log(String message) {
        this.dateTime = LocalDate.now();
        this.message = message;
    }

   public String getMessage() {
        return message;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }
    
}

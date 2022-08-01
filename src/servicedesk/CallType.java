/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package servicedesk;

import java.util.List;

/**
 *
 * @author chrismcguinness
 */
public interface CallType {
    
    String getType();
    void populateListItems();
    List<String> getItems();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicedesk;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author chrismcguinness
 */
public class Hardware implements CallType
{
    public String callType = "Hardware";

    public List<String> items;

    public void Software(){populateListItems();}

    public String getType(){ return callType;}

    public List<String> getItems(){ return items;};

    public void populateListItems()
    {
        List<String> listItems = new ArrayList<String>();

        listItems.add("Monitor");
        listItems.add("Printer");
        listItems.add("Laptop");
        listItems.add("Mouse");
        listItems.add("Keyboard");

        items = listItems;
    }

}

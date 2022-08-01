/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicedesk;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chrismcguinness
 */
class Software implements CallType
{
    public String callType = "Software";

    public List<String> items;

    public void Software(){populateListItems();}

    public String getType(){ return callType;}

    public List<String> getItems(){ return items;};

    public void populateListItems()
    {
        List<String> listItems = new ArrayList<String>();

        listItems.add("Software Application");
        listItems.add("Website");
        listItems.add("Password Reset");
        listItems.add("Emails");
        listItems.add("On Boarding");

        items = listItems;
    }

}

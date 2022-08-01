package servicedesk;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pot {

  //CLASS ATTRIBUTES 
  private int id;
  private String name;
  private Employee employee;
  private List < Call > calls;

  //CONSTRUCTOR
  public Pot(int id, String name, Employee employee) {
    this.id = id;
    this.name = name;
    this.employee = employee;
    this.calls = populateCalls();

  }

  //GETTERS
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Employee getEmployee() {
    return employee;
  }

  public List < Call > getCalls() {
    return calls;
  }
  //GETTERS - END

  //In the real world scenairo a database call will be 
  //made using the pot id to get the calls that currently belong
  //to this pot. In this instance well be we'll generate some 
  //sample calls
  private List < Call > populateCalls() {
    List < Call > callList = new ArrayList < Call > ();
    List < String > imageUrl = new ArrayList < String > ();
    imageUrl.add("Https://www.test.test/test1.jpg");
    imageUrl.add("Https://www.test.test/test2.jpg");
    imageUrl.add("Https://www.test.test/test3.jpg");

    for (int i = 1; i <= 5; i++) {
      callList.add(new Call(i,
        "Test Call " + i,
        "Test Description " + i,
        imageUrl,
        Status.Open,
        new Hardware(),
        employee.getEmployeeId(),
        employee.getName(),
        0,
        null,
        new Date()));
    }

    return callList;
  }

  //This will be a halper method to check the calls have been 
  //instatated correctly
  public void viewCalls() {
    List < Integer > callIdLists = new ArrayList < Integer > ();

    System.out.println("Logged in User: Hello, " + this.employee.getName() + ".\n");
    System.out.println("Current Selected Pot: '" + this.name + "'.\n\n");
    System.out.println("Open Calls: \n");
    for (Call call: calls) {

      callIdLists.add(call.getCallId());

      System.out.println("Id: " + call.getCallId() +
        ". -Tile: '" + call.getTile() +
        "' -Call Type: '" + call.getCalltype() +
        "' -Status: '" + call.getStatus() +
        "'" +
        "\n- Call Description: " + call.getDescription());
    }

    getUserInput();
  }

  //Get users input on what they'd like to do next either display an 
  //existing call or create a new instance.
  private void getUserInput() {
    System.out.println("\nPlease input the call you'd like to view.\n");
    System.out.println("Type 'New' to create a new call.\n");

    Scanner myScanner = new Scanner(System.in); // Create a Scanner object
    String inputString = myScanner.nextLine(); // Read user input

    try {
      Integer callInteger = Integer.parseInt(inputString);

      // Requires this try catch to make sure that the call 
      //id parsed exists within the call list
      try {
        //View the user call.
        calls.get(callInteger - 1).displayCallDetails();

        //Reload and view all calls
        viewCalls();
      } catch (Exception e) {
        System.out.println("\nThe call Id: " +
          callInteger +
          " doesnt exist within this Pot.\n");
        //Reload and get a new user input
        getUserInput();
      }
    } catch (Exception e) {
      //Check that the input is 'new' else print out a message.
      if (inputString.toLowerCase().equals("new")) {

        //Create new Calls
        getNewCallDetails();

        //Reload and view all calls
        viewCalls();
      } else {
        System.out.println("\nUnsupported input please try again.\n");

        //After all the the inputs have been preformed 
        //we recall the view calls method
        getUserInput();
      }

    }
  }

  //Get the users input in order for them to define the new details of 
  //the call instance to be created
  private void getNewCallDetails() {
    Scanner myScanner = new Scanner(System.in); // Create a Scanner object

    try {
      System.out.println("\nNew Call:\n");
      System.out.println("\nPlease Type the Title:\n");
      String tileString = myScanner.nextLine();
      System.out.println("\nPlease Type the Descripion:\n");
      String descripionString = myScanner.nextLine();

      //Url Variables
      boolean completedURLs = true;
      List < String > imageUrlList = new ArrayList < String > ();
      String imageURLString = "";
      System.out.println("\nPlease input the images URLs. " +
        "Leave Blank if no more are required:\n");

      //While to populate the URLS
      while (completedURLs) {
        imageURLString = myScanner.nextLine();

        if (imageURLString.equals("")) {
          completedURLs = false;
        } else {
          imageUrlList.add(imageURLString);
        }
      }

      boolean typeSelected = true;
      String typeString = "";
      System.out.println("\nPlease input the Call Type, " +
        "Please Select either 'Hardware' or " +
        "'Software'.\n");

      //While for setting call type either the hardware and software
      while (typeSelected) {
        typeString = myScanner.nextLine();

        if (typeString.toLowerCase().equals("hardware")) {
          typeSelected = false;
        } else if (typeString.toLowerCase().equals("software")) {
          typeSelected = false;
        } else {
          System.out.println("\nNon-supported call tpye.\n");
          System.out.println("\nPlease input the Call Type:\n");
        }

      }

      //add newly created call to list
      calls.add(createNewCall(tileString, descripionString, imageUrlList, typeString));

    } catch (Exception e) {
      System.out.println("\nERROR: Failed creating new call please try again.\n");
      getNewCallDetails();
    }

    //After the call has been created return back to view all calls 
    viewCalls();
  }

  // return new instance of Call 
  public Call createNewCall(String tileString, String descripionString, List < String > imageUrlList, String typeString) {
    //Create the new instance of a call 
    //and add it to the pots lists
    if (typeString.toLowerCase().equals("hardware")) {
      return new Call(calls.size() + 1,
        tileString,
        descripionString,
        imageUrlList,
        Status.Open,
        new Hardware(),
        employee.getEmployeeId(),
        employee.getName(),
        0,
        null,
        new Date());
    } else {
      return new Call(calls.size() + 1,
        tileString,
        descripionString,
        imageUrlList,
        Status.Open,
        new Software(),
        employee.getEmployeeId(),
        employee.getName(),
        0,
        null,
        new Date());
    }
  }
}
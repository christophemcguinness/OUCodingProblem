package servicedesk;

import com.sun.org.apache.xpath.internal.compiler.Keywords;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Call {

  //Attributes
  private int callId;
  private String tile;
  private String description;
  private List < String > imageUrls;
  private Status status;
  private CallType calltype;
  private List < String > callItems;
  private int raiserId;
  private String raiser;
  private int supportUserId;
  private String supportUser;
  private List < String > keywords;
  private List < Log > logs;
  private Date creationDate;
  private KnowledgeBase kb;

  //CONSTRUCTOR
  public Call(int callId, String tile, String description, List < String > imageUrls,
    Status status, CallType calltype, int raiserId, String raiser,
    int supportUserId, String supportUser, Date creationDate) throws NullPointerException {
    this.callId = callId;
    this.tile = tile;
    this.description = description;
    this.imageUrls = imageUrls;
    this.status = status;
    this.calltype = calltype;
    this.raiserId = raiserId;
    this.raiser = raiser;
    this.supportUserId = supportUserId;
    this.supportUser = supportUser;
    this.keywords = PopulateKeywords(description);
    this.logs = PopulateLogs();
    this.creationDate = creationDate;
    this.kb = new KnowledgeBase();
  }

  //GETTERS AND SETTERS
  Integer getCallId() {
    return this.callId;
  }

  String getTile() {
    return this.tile;
  }

  CallType getCalltype() {
    return this.calltype;
  }

  Status getStatus() {
    return this.status;
  }

  String getDescription() {
    return this.description;
  }

    public List<String> getCallItems() {
        return callItems;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public KnowledgeBase getKb() {
        return kb;
    }
 
  //In the real world scenario a database call will be 
  //made to get the calls logs and if non exist it creates 
  //a new creation log.
  public List < Log > PopulateLogs() {

    List < Log > logs = new ArrayList < Log > ();
    for (int i = 0; i < 5; i++) {
      logs.add(new Log("New Log Message" + i));
    }
    return logs;
  }

  //In the real world scenario these 
  //will be generated each time the decription changes.
  //As none of the examples focus on the keyword generation
  //proper keyword generation logic not fully implemented.
  //In this method all it will currently do is use the decription 
  //to generate and return a list of all the keywords
  public List < String > PopulateKeywords(String description) {

    String[] descriptionSplit = description.split(" ");
    List < String > listOfKeywords = new ArrayList();
    Collections.addAll(listOfKeywords, descriptionSplit);
    return listOfKeywords;
  }

  //Display call details for testing.
  void displayCallDetails() {
    System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||");

    System.out.println("\nCall Id - " + this.callId);
    System.out.println("\nTitle - " + this.tile);
    System.out.println("\nDescription - " + this.description);
    System.out.println("\nImage URLS:");
    System.out.println("\n---------------");
    for (String urlString: imageUrls) {
      System.out.println("\n- " + urlString);
    }
    System.out.println("\n---------------");
    System.out.println("Status - " + this.status);
    System.out.println("\nCall Type - " + this.calltype);
    System.out.println("\nRaiser - " + this.raiser);
    System.out.println("\nCurrently Assigned Support User - " + this.supportUser);
    System.out.println("\nCreation Date - " + this.creationDate.toString());

    System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||\n");

    getUserInput();
  }

  //Get user input
  private void getUserInput() {
    Scanner myScanner = new Scanner(System.in); // Create a Scanner object

    if (this.status.equals(status.Open)) {
      System.out.println("\nType 'Close' to close the call.\n");
      System.out.println("Anything else will return to the Pot\n");

      String inputString = myScanner.nextLine(); // Read user input

      if (inputString.toLowerCase().equals("close")) {
        closeCall();
        checkForEntitiesToLink();
      }

    } else {
      System.out.println("\nCall Closed.\n");
      System.out.println("\nAnything to return to the Pot\n");

      String inputString = myScanner.nextLine(); // Read user input
    }
  }

public void closeCall()
{
    System.out.println("\nCall Closed\n");
        this.status = Status.Closed;
}

  //create instance of knowledgebase and link or create a new entity.
  private void checkForEntitiesToLink() {
    boolean callLinked = kb.checkKeywordsForLink(this.keywords, this.callId);
    if (!callLinked) {
      kb.createEntityInformation(this.callId, this.keywords);
      System.out.println("\nNew Entity Created\n");

    } else {
      System.out.println("\nEntity Linked\n");
    }
  }

}
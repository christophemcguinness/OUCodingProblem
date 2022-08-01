package servicedesk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnowledgeBase {

  public List < KnowledgeBaseEntity > listOfKnowledgeBaseEntities;

  public KnowledgeBase() {
    //Database call passing the keywords but in our example we use hardcode this
    //as at this stage we've not implemented a database solution.
    this.listOfKnowledgeBaseEntities = populateEntities();
  }

    public List<KnowledgeBaseEntity> getListOfKnowledgeBaseEntities() {
        return listOfKnowledgeBaseEntities;
    }


  //In the real world scenario the logic will be in place 
  //to gather any related calls from the database. For this demo
  //a simple entity will be created. With "Server" and "Issue" 
  //within the keywords
  private List < KnowledgeBaseEntity > populateEntities() {
    List < KnowledgeBaseEntity > entitiesList = new ArrayList < KnowledgeBaseEntity > ();
    List < String > stepsList = new ArrayList < String > ();
    List < String > KeywordsList = new ArrayList < String > ();
    List < Integer > callIdList = new ArrayList < Integer > ();

    stepsList.add("Step 1");
    stepsList.add("Step 2");
    stepsList.add("Step 3");

    KeywordsList.add("Server");
    KeywordsList.add("Issue");

    callIdList.add(45);
    callIdList.add(62);

    entitiesList.add(new KnowledgeBaseEntity(54,
      "Title of Entity",
      "This is a description of an entity",
      stepsList,
      KeywordsList,
      Status.Open,
      callIdList));

    return entitiesList;
  }

  //retrun bool true if the user decides to link an 
  //existing entity false if they wish to create a new one.
  boolean checkKeywordsForLink(List < String > keywords, Integer callId) {
    
    List < KnowledgeBaseEntity > matchedEntitys = new ArrayList < KnowledgeBaseEntity > ();

    for (KnowledgeBaseEntity entity: this.listOfKnowledgeBaseEntities) {
      for (String keyword: keywords) {
        if (entity.getKeywords().contains(keyword)) {
          matchedEntitys.add(entity);
          break;
        }
      }

    }

    boolean callLinked = false;

    if (matchedEntitys.size() > 0) {
      System.out.println("\nSimalar Entities Found\n");
      for (KnowledgeBaseEntity entity: matchedEntitys) {
        System.out.println("\n" + entity.getEntityid() +
          " - Title: " + entity.getEntityTitle() +
          " - Description: " + entity.getEntityDescription());
      }
      callLinked = checkIfUserWantsToLink(callId, matchedEntitys);
    }

    return callLinked;
  }

  //check if the user wants to link an existing entity if not then return false.
  private boolean checkIfUserWantsToLink(Integer callId, List < KnowledgeBaseEntity > matchedEntitys) {
    System.out.println("\nPlease input the Entity id you'd like to link:\n");

    Scanner myScanner = new Scanner(System.in); // Create a Scanner object
    String inputString = myScanner.nextLine(); // Read user input
    if (!inputString.toLowerCase().equals("")) {
      try {
        Integer entityInteger = Integer.parseInt(inputString);

        // Requires this try catch to make sure that the entity 
        //id is set correctly
        try {

          boolean idFound = false;

          //View the user call.
          for (KnowledgeBaseEntity entity: matchedEntitys) {
            if (entity.getEntityid() == entityInteger) {
              idFound = true;
              entity.addCall(callId);
              return true;
            }
          }
          if (!idFound) {
            throw new Exception("entityId Not Found");
          }

        } catch (Exception e) {
          System.out.println("\nThe entity Id: " +
            entityInteger +
            " doesnt exist within this Pot.\n");
          //Reload and get a new user input
          checkIfUserWantsToLink(callId, matchedEntitys);
        }
      } catch (Exception e) {
        System.out.println("\nUnsupported input please try again.\n");

        //Reload and get a new user input
        checkIfUserWantsToLink(callId, matchedEntitys);
      }
    }

    return false;

  }
  //return newly created entity
  public void createEntityInformation(int callRef, List < String > keywords) {
    Scanner myScanner = new Scanner(System.in); // Create a Scanner object

    try {
      System.out.println("\nNew Entity:\n");
      System.out.println("\nPlease Type the Title:\n");
      String titleString = myScanner.nextLine();
      System.out.println("\nPlease Type the Descripion:\n");
      String descriptionString = myScanner.nextLine();

      //Steps Variables
      boolean completedSteps = true;
      List < String > stepsToResolve = new ArrayList < String > ();
      String stepString = "";
      System.out.println("\nPlease input the steps to complete. " +
        "Leave Blank if no more are required:\n");

      //While to populate the URLS
      while (completedSteps) {
        stepString = myScanner.nextLine();

        if (stepString.equals("")) {
          completedSteps = false;
        } else {
          stepsToResolve.add(stepString);
        }
      }

      ArrayList < Integer > callIdList = new ArrayList < Integer > ();
      callIdList.add(callRef);

      CreateEntity(titleString, descriptionString, stepsToResolve,
        keywords, callIdList);

    } catch (Exception e) {
      System.out.println("\nERROR: Failed creating new call please try again.\n");
      createEntityInformation(callRef, keywords);
    }
  }

  public void CreateEntity(String titleString,
    String descriptionString,
    List < String > stepsToResolve,
    List < String > keywords,
    List < Integer > callIdList) {
    listOfKnowledgeBaseEntities.add(new KnowledgeBaseEntity(this.listOfKnowledgeBaseEntities.size() + 1,
      titleString,
      descriptionString,
      stepsToResolve,
      keywords,
      Status.Open,
      callIdList));
  }
}
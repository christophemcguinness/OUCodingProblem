package servicedesk;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static servicedesk.PotTest.potInstance;
import static servicedesk.PotTest.userInstance;

public class CallTest {

  static Support userInstance;
  static Pot potInstance;

  public CallTest() {}

  @BeforeClass
  public static void setUpClass() {
    userInstance = new Support("Chris McGuinness", "Christophemcguinness@gmail.com", 1);
    potInstance = new Pot(1, "Service Desk Main Pot", userInstance);
  }

  @Test
  public void ConfirmKnowledgeBaseLinkExistAndEntitiesExistWithinIt() {

    System.out.println("--------------------------------");
    System.out.println("TEST - ConfirmKnowledgeBaseLinkExistAndEntitiesExistWithinIt()");
    System.out.println("--------------------------------\n");
    potInstance = new Pot(1, "Service Desk Main Pot", userInstance);

    List < KnowledgeBaseEntity > KnowledgeBaseEntitiesActutal =
      potInstance.getCalls().get(0).getKb().listOfKnowledgeBaseEntities;

    List < KnowledgeBaseEntity > KnowledgeBaseEntitiesExpected = populateTestEntities();

    for (int i = 0; i < KnowledgeBaseEntitiesActutal.size(); i++) {

      System.out.println("EntityId index at " + i + " and expected " +
        KnowledgeBaseEntitiesExpected.get(i).getEntityid() +
        " and actual was " + KnowledgeBaseEntitiesActutal.get(i).getEntityid());

      assertEquals("ERROR: EntityId index at " + i + " and expected " +
        KnowledgeBaseEntitiesExpected.get(i).getEntityid() +
        " but actual was " + KnowledgeBaseEntitiesActutal.get(i).getEntityid(),
        KnowledgeBaseEntitiesExpected.get(i).getEntityid(),
        KnowledgeBaseEntitiesActutal.get(i).getEntityid());

      System.out.println("Title index at " + i + " and expected " +
        KnowledgeBaseEntitiesExpected.get(i).getEntityTitle() +
        " and actual was " + KnowledgeBaseEntitiesActutal.get(i).getEntityTitle());

      assertEquals("ERROR: Entity Title index at " + i + " and expected " +
        KnowledgeBaseEntitiesExpected.get(i).getEntityTitle() +
        " but actual was " + KnowledgeBaseEntitiesActutal.get(i).getEntityTitle(),
        KnowledgeBaseEntitiesExpected.get(i).getEntityTitle(),
        KnowledgeBaseEntitiesActutal.get(i).getEntityTitle());

      System.out.println("Description index at " + i + " and expected " +
        KnowledgeBaseEntitiesExpected.get(i).getEntityDescription() +
        " and actual was " + KnowledgeBaseEntitiesActutal.get(i).getEntityDescription());

      assertEquals("ERROR: Entity description index at " + i + " and expected " +
        KnowledgeBaseEntitiesExpected.get(i).getEntityDescription() +
        " but actual was " + KnowledgeBaseEntitiesActutal.get(i).getEntityDescription(),
        KnowledgeBaseEntitiesExpected.get(i).getEntityDescription(),
        KnowledgeBaseEntitiesActutal.get(i).getEntityDescription());

      for (int y = 0; y < KnowledgeBaseEntitiesExpected.get(i).getStepsToResolve().size(); y++) {
        System.out.println("Steps to resolve index at " + y + " and expected " +
          KnowledgeBaseEntitiesExpected.get(i).getStepsToResolve().get(y) +
          " and actual was " + KnowledgeBaseEntitiesActutal.get(i).getStepsToResolve().get(y));

        assertEquals("ERROR: Entity steps to resolve index at " + i + " and expected " +
          KnowledgeBaseEntitiesExpected.get(i).getStepsToResolve().get(y) +
          " but actual was " + KnowledgeBaseEntitiesActutal.get(i).getStepsToResolve().get(y),
          KnowledgeBaseEntitiesExpected.get(i).getStepsToResolve().get(y),
          KnowledgeBaseEntitiesActutal.get(i).getStepsToResolve().get(y));
      }

      for (int y = 0; y < KnowledgeBaseEntitiesExpected.get(i).getKeywords().size(); y++) {
        System.out.println("Keywords index at " + y + " and expected " +
          KnowledgeBaseEntitiesExpected.get(i).getKeywords().get(y) +
          " and actual was " + KnowledgeBaseEntitiesActutal.get(i).getKeywords().get(y));

        assertEquals("ERROR: Entity Keywords index at " + i + " and expected " +
          KnowledgeBaseEntitiesExpected.get(i).getKeywords().get(y) +
          " but actual was " + KnowledgeBaseEntitiesActutal.get(i).getKeywords().get(y),
          KnowledgeBaseEntitiesExpected.get(i).getKeywords().get(y),
          KnowledgeBaseEntitiesActutal.get(i).getKeywords().get(y));
      }
      System.out.println("Title Status at " + i + " and expected " +
        KnowledgeBaseEntitiesExpected.get(i).getStatus() +
        " and actual was " + KnowledgeBaseEntitiesActutal.get(i).getStatus());

      assertEquals("ERROR: Entity Stauts index at " + i + " and expected " +
        KnowledgeBaseEntitiesExpected.get(i).getStatus() +
        " but actual was " + KnowledgeBaseEntitiesActutal.get(i).getStatus(),
        KnowledgeBaseEntitiesExpected.get(i).getStatus(),
        KnowledgeBaseEntitiesActutal.get(i).getStatus());

      for (int y = 0; y < KnowledgeBaseEntitiesActutal.get(i).getCallLinks().size(); y++) {
        System.out.println("Linked call index at " + y + " and expected " +
          KnowledgeBaseEntitiesExpected.get(i).getCallLinks().get(y) +
          " and actual was " + KnowledgeBaseEntitiesActutal.get(i).getCallLinks().get(y));

        assertEquals("ERROR: Linked call index at " + y + " and expected " +
          KnowledgeBaseEntitiesExpected.get(i).getCallLinks().get(y) +
          " but actual was " + KnowledgeBaseEntitiesActutal.get(i).getCallLinks().get(y),
          KnowledgeBaseEntitiesExpected.get(i).getCallLinks().get(y),
          KnowledgeBaseEntitiesActutal.get(i).getCallLinks().get(y));
      }
    }

  }

  @Test
  public void ClosingCallAndCreatingNewInstance() {

    String titleString = "KB - New Entity";
    String descriptionString = " New Description";

    List < String > stepsToResolve = new ArrayList < String > ();
    stepsToResolve.add("Step 1");
    stepsToResolve.add("Step 2");

    List < String > keywords = new ArrayList < String > ();
    keywords.add("ABC");
    keywords.add("DEF");

    List < Integer > callIdList = new ArrayList < Integer > ();
    callIdList.add(potInstance.getCalls().get(0).getCallId());

    System.out.println("--------------------------------");
    System.out.println("TEST - ClosingCallAndCreatingNewInstance()");
    System.out.println("--------------------------------\n");

    System.out.println("Expected Status is " + Status.Open +
      " and actual was " + potInstance.getCalls().get(0).getStatus());

    assertEquals("ERROR: Expected Status is " + Status.Open +
      " but actual was " + potInstance.getCalls().get(0).getStatus(),
      Status.Open, potInstance.getCalls().get(0).getStatus());

    potInstance.getCalls().get(0).closeCall();

    System.out.println("Expected Status is " + Status.Closed +
      " and actual was " + potInstance.getCalls().get(0).getStatus());

    assertEquals("ERROR: Expected Status is " + Status.Closed +
      " but actual was " + potInstance.getCalls().get(0).getStatus(),
      Status.Closed, potInstance.getCalls().get(0).getStatus());

    System.out.print("\n");

    potInstance.getCalls().get(0).getKb().CreateEntity(titleString,
      descriptionString,
      stepsToResolve,
      keywords,
      callIdList);

    Integer entityID = potInstance.getCalls().get(0).getKb().getListOfKnowledgeBaseEntities().size() - 1;
    KnowledgeBaseEntity myTestKnowledgeBaseEntity = potInstance.getCalls().get(0).getKb().getListOfKnowledgeBaseEntities().get(entityID);

    System.out.println("Expected Title is " + titleString +
      " and actual was " + myTestKnowledgeBaseEntity.getEntityTitle());

    assertEquals("ERROR: Expected Title is " + titleString +
      " but actual was " + myTestKnowledgeBaseEntity.getEntityTitle(),
      titleString, myTestKnowledgeBaseEntity.getEntityTitle());

    System.out.println("Expected Description is " + descriptionString +
      " and actual was " + myTestKnowledgeBaseEntity.getEntityDescription());

    assertEquals("ERROR: Expected Description is " + descriptionString +
      " but actual was " + myTestKnowledgeBaseEntity.getEntityDescription(),
      descriptionString, myTestKnowledgeBaseEntity.getEntityDescription());

    for (int i = 0; i < myTestKnowledgeBaseEntity.getStepsToResolve().size(); i++) {

      System.out.println("StepsToResolve index at " + i + " and expected " +
        myTestKnowledgeBaseEntity.getStepsToResolve().get(i) +
        " and actual was " + stepsToResolve.get(i));

      assertEquals("ERROR: StepsToResolve index at " + i + " and expected " +
        myTestKnowledgeBaseEntity.getStepsToResolve().get(i) +
        " but actual was " + stepsToResolve.get(i),
        stepsToResolve.get(i),
        myTestKnowledgeBaseEntity.getStepsToResolve().get(i));
    }

    for (int i = 0; i < myTestKnowledgeBaseEntity.getKeywords().size(); i++) {

      System.out.println("Keywords index at " + i + " and expected " +
        myTestKnowledgeBaseEntity.getKeywords().get(i) +
        " and actual was " + keywords.get(i));

      assertEquals("ERROR: Keywords index at " + i + " and expected " +
        myTestKnowledgeBaseEntity.getKeywords().get(i) +
        " but actual was " + keywords.get(i),
        keywords.get(i),
        myTestKnowledgeBaseEntity.getKeywords().get(i));
    }

    for (int i = 0; i < myTestKnowledgeBaseEntity.getCallLinks().size(); i++) {

      System.out.println("callIdList index at " + i + " and expected " +
        myTestKnowledgeBaseEntity.getCallLinks().get(i) +
        " and actual was " + callIdList.get(i));

      assertEquals("ERROR: callIdList index at " + i + " and expected " +
        myTestKnowledgeBaseEntity.getCallLinks().get(i) +
        " but actual was " + callIdList.get(i),
        callIdList.get(i),
        myTestKnowledgeBaseEntity.getCallLinks().get(i));
    }

    System.out.print("\n");

  }

  @Test(expected = NullPointerException.class)
  public void CreatingNewEntitiesWithNoDetails() {
    System.out.println("--------------------------------");
    System.out.println("TEST - testCreatingNewEntitiesWithNoDetails()");
    System.out.println("--------------------------------\n");
    System.out.println("Should throw Null Pointer expection if pass no steps to create.");
    System.out.println("\n");
    potInstance.getCalls().get(0).getKb().CreateEntity(null,
      null,
      null,
      null,
      null);
  }

  ///In a real world test we'd perhaps have a testing database setup with 
  //examples that will be consistance as apposed to hard coded like below
  private List < KnowledgeBaseEntity > populateTestEntities() {
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

}
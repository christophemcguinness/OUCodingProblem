package servicedesk;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PotTest {

  static Support userInstance;
  static Pot potInstance;
  static List < String > imageUrlList;
  static String callType;

  public PotTest() {}

  @BeforeClass
  public static void setUpClass() {
    userInstance = new Support("Chris McGuinness", "Christophemcguinness@gmail.com", 1);
    potInstance = new Pot(1, "Service Desk Main Pot", userInstance);
    imageUrlList = new ArrayList < String > ();
  }

  @Test
  public void testAllLinkedObjectsHaveBeenCreated() {
    System.out.println("--------------------------------");
    System.out.println("TEST - testAllLinkedObjectsHaveBeenCreated()");
    System.out.println("--------------------------------\n");

    String title = "New Call - testCreatingAllLinkedObjectsHaveBeenCreated";
    String description = "";
    imageUrlList.add("www.Image.com/image.png");
    imageUrlList.add("www.Image.com/image1.png");
    callType = "Software";

    potInstance.getCalls().add(potInstance.createNewCall(title, description, imageUrlList, callType));
    int callIndex = potInstance.getCalls().size() - 1;

    List < Log > logResult = potInstance.getCalls().get(callIndex).getLogs();
    List < String > callItemResult = potInstance.getCalls().get(callIndex).getCallItems();

    System.out.println("Logs count was 5 and actual was " + logResult.size());
    assertEquals("ERROR: expected logs count was 5 but actual was " + logResult.size(), 5, logResult.size());

    System.out.println("CallItem count was 5 and actual was " + callItemResult.size());
    assertEquals("ERROR: expected CallItem count was 5 but actual was " + callItemResult.size(), 5, callItemResult.size());

    for (int i = 0; i < logResult.size(); i++) {
      System.out.println("Log at index " + i +
        " was New Log Message" + i + " and actual was " +
        logResult.get(i).getMessage());

      assertEquals("ERROR: expected Log at index " + i +
        " was New Log Message" + i + " but actual was " +
        logResult.get(i).getMessage(), "New Log Message" + i, logResult.get(i).getMessage());
    }

    System.out.println("\n");
  }

  @Test
  public void testInstancesCreatedMatchesWhatWasPassedToCreateMethod() {
    System.out.println("--------------------------------");
    System.out.println("TEST - testAllPostConditions()");
    System.out.println("--------------------------------\n");

    String title = "New Call - testAllPostConditions";
    String description = "";
    imageUrlList.add("www.Image.com/image.jpg");
    imageUrlList.add("www.Image.com/image2.jpg");
    String callType = "Hardware";

    potInstance.getCalls().add(potInstance.createNewCall(title, description, imageUrlList, callType));
    int callIndex = potInstance.getCalls().size() - 1;

    String titleResult = potInstance.getCalls().get(callIndex).getTile();
    String descriptionResult = potInstance.getCalls().get(callIndex).getDescription();
    List < String > imageUrlResult = potInstance.getCalls().get(callIndex).getImageUrls();
    CallType callTypeResult = potInstance.getCalls().get(callIndex).getCalltype();

    System.out.println("Expected Title " + title + " and actual was " +
      titleResult);
    assertEquals("ERROR: expected Title " + title + " but actual was " +
      titleResult, title, titleResult);

    System.out.println("Expected Description " + description +
      " and actual was " + descriptionResult);
    assertEquals("ERROR: expected Description " + description +
      " but actual was " + descriptionResult, description, descriptionResult);

    System.out.println("Expected imageUrl count was " + imageUrlList.size() +
      " And actual was " + imageUrlResult.size());
    assertEquals("ERROR: expected imageUrl count was " + imageUrlList.size() +
      " but actual was " + imageUrlResult.size(), imageUrlList.size(), imageUrlResult.size());

    for (int i = 0; i < imageUrlList.size(); i++) {
      System.out.println("Expected imageUrlList at index " + i + " was " +
        imageUrlList.get(i) + " and actual was " +
        imageUrlResult.get(i));
      assertEquals("ERROR: expected imageUrlList at index " + i + " was " +
        imageUrlList.get(i) + " but actual was " +
        imageUrlResult.get(i), imageUrlList.get(i), imageUrlResult.get(i));
    }

    System.out.println("\n");

  }

  @Test(expected = NullPointerException.class)
  public void testCreatingNewCallWithNoDetails() {
    System.out.println("--------------------------------");
    System.out.println("TEST - testCreatingNewCallWithNoDetails()");
    System.out.println("--------------------------------\n");
    System.out.println("Should throw Null Pointer expection if pass");
    System.out.println("\n");
    potInstance.getCalls().add(potInstance.createNewCall(null, null, null, null));
  }

  private CallType SetCallListItems(String calltype) {
    CallType callType = null;

    if (calltype == "Hardware") {
      callType = new Hardware();
      
    } else if (calltype == "Software") {
      callType  = new Software();
      
    }
    return callType;

  }

}
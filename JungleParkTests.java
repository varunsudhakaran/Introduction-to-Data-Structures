import java.util.ArrayList;


////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program5_JunglePark2000
//Files: ParkGUI.java, JunglePark.java, AddAnimalButton.java
//Button.java, ClearButton.java, Animal.java, Deer.java
//Tiger.java, JungleParkTests.java
//Course: CS 300, Semester 1, and Freshman
//
//Author: Varun Sudhakaran
//Email: vsudhakaran@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class JungleParkTests extends JunglePark {

  private static JunglePark park; // PApplet object that represents the 
                                  //display
                                  // window of this program

  /**
   * This method checks whether isClose() called by a Deer returns true 
   * if a tiger is within its
   * scanRange area and false if called with another tiger 
   * as input parameter located outside 
   * the scanRange area
   * 
   * @return true when test verifies correct functionality, 
   * and false otherwise.
   */
  public static boolean test1isCloseMethod() {
    boolean passed = true;

    // This is an example. You can define your own test scenario 
    //for this method
    // Create a deer and two tigers
    Deer d = new Deer(park); // initializes deer
    Tiger t1 = new Tiger(park); // initializes tiger
    Tiger t2 = new Tiger(park); // initializes tiger
    // Set deer at position(200,200)
    d.setPositionX(200);
    d.setPositionY(200);
    // Set first tiger at position(400,200)
    t1.setPositionX(400); // tiger is 200px away from deer
    t1.setPositionY(200);
    // Set second tiger at position(300,200)
    t2.setPositionX(300); // tiger is 100px away from deer
    t2.setPositionY(200);
    if (d.isClose(t1, 175)) { // bug! isClose() should return false here
      System.out.println("Deer's isClose is returning true when it "
          + "should return false.");
      // prints message 
      passed = false; // sets passed to false
    }
    if (!d.isClose(t2, 175)) { // bug! isClose() should return 
      //true here
      System.out.println("Deer's isClose is returning false when "
          + "it should return true.");
      passed = false; // sets passed to false
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of 
    //listGUI to get ready for a next scenario

    return passed; // returns passed
  }

  /**
   * This method checks whether isClose() called by a 
   * Tiger returns false if another tiger is
   * located outside its scanRange area
   * 
   * @return true when test verifies correct functionality, 
   * and false otherwise.
   */
  public static boolean test2isCloseMethod() {
    boolean passed = true;
    // TODO Define your test scenario here
    Deer d1 = new Deer(park); // initializes deer
    Deer d2 = new Deer(park); // initializes deer
    Tiger t1 = new Tiger(park); // initializes tiger
    Tiger t2 = new Tiger(park); // initializes tiger
    
    // sets deer to position (300, 400)
    d1.setPositionX(300);
    d1.setPositionY(400);
    //////////
    // sets tiger to position (200, 500)
    t1.setPositionX(200);
    t1.setPositionY(500);
    //////////
    if(!d1.isClose(t1, 175)) { // checks if deer is close
      System.out.println("Deer's isClose() method is returning "
          + "false when it should return true");
      passed = false;
    }
    //////////
    d2.setPositionX(100);
    d2.setPositionY(100);
    //////////
    t2.setPositionX(300);
    t2.setPositionY(300);
    //////////
    if(d2.isClose(t2,175)) {
      System.out.println("Deer's isClose() method is "
          + "returning true when it should be false");
      passed = false;
    }
    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of 
    //listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether the deer detects a Tiger present 
   * at its proximity
   * 
   * @param: none
   * 
   * @return true when test verifies correct functionality, 
   * and false otherwise.
   */
  public static boolean test1DeerScanForThreatMethod() {
    boolean passed = true;
    // TODO Define your test scenario here
    Deer d1 = new Deer(park);
    // initializes deer
    park.listGUI.add(d1);
    // adds to list
    Tiger t1 = new Tiger(park);
    // initializes tiger
    park.listGUI.add(t1);
    // adds to list
    d1.setPositionX(200); // sets position
    d1.setPositionY(100); // sets position
    /////////
    t1.setPositionX(200); // sets position
    t1.setPositionY(150); // sets position
    /////////
    if(!d1.scanForThreat(70)) { // scans
      System.out.println("Deer's scanForThreat() method "
          + "is returning true, but should be returning false.");
      // prints message
      passed = false;
      // sets passed to false
    }
    
    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of 
    //listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether your scanForThreat() method 
   * returns false if no Tiger is present
   * within a specific range distance from it
   * 
   * @return true when test verifies correct functionality, 
   * and false otherwise.
   */
  public static boolean test2DeerScanForThreatMethod() {
    boolean passed = true;
    // TODO Define your test scenario here
    Deer d1 = new Deer(park);
    // initializes deer
    park.listGUI.add(d1);
    // adds to list
    Tiger t1 = new Tiger(park);
    // initialized 
    park.listGUI.add(t1);
    d1.setPositionX(100); // sets position
    d1.setPositionY(100); // sets position
    //////////
    t1.setPositionX(100); // sets position
    t1.setPositionY(150); // sets position
    //////////
    if(d1.scanForThreat(40)) { // scans
      System.out.println("Deer's scanForThreat() method "
          + "is returning true, but should be returning false.");
      // prints message
      passed = false;
      // sets passed to false
    }
    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI 
    //to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether the tiger hops on the deer 
   * provided to the hop() method as input
   * argument. (1) The tiger should take the position of 
   * the deer. (2) The unfortunate deer should
   * be removed from the JunglePark listGUI. (3) 
   * The eatenDeerCount should be incremented.
   * 
   * @param: none
   * 
   * @return true when test verifies correct 
   * functionality, and false otherwise.
   * 
   */
  public static boolean testTigerHopMethod() {
    boolean passed = true;
    // This is an example. You may develop different 
    //scenarios to assess further the correctness of 
    // your hop() method
    // Create one deer and one tiger
    Deer d = new Deer(park);
    Tiger t = new Tiger(park);
    // Set the deer at position(250,250)
    d.setPositionX(250);
    d.setPositionY(250);
    // Set the tiger at position(300,300) tiger is 
    //70.71px away from deer d1
    t.setPositionX(300);
    t.setPositionY(300);
    // add the tiger and the deer to the JunglePark (i.e. to listGUI)
    park.listGUI.add(d);
    park.listGUI.add(t);
    t.hop(d); // tiger hops on the deer
    if (t.getPositionX() != d.getPositionX() 
        && t.getPositionY() != d.getPositionY()) {
      // tiger should move to the position of the deer
      System.out.println("Tiger did not move correctly "
          + "when hopping.");
      passed = false; // sets passed to false
    }
    if (park.listGUI.contains(d)) {
      // deer should be removed from the park
      System.out.println("Deer was not removed after "
          + "being hopped on.");
      passed = false; // sets passed to false
    }
    if (t.getDeerEatenCount() != 1) { 
      // deerEatenCount should be incremented. It was 0
      System.out.println("deerEatenCount should be "
          + "incremented "
          + "after the tiger hopped on a deer.");
      // prints message
      passed = false; // sets passed to false
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of 
    //listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * runs JungleParkTests program as a PApplet client
   * 
   * @param args
   * 
   * @return: none
   * 
   */
  public static void main(String[] args) {
    // Call PApplet.main(String className) to start 
    //this program as a PApplet client application
    PApplet.main("JungleParkTests");
  }

  /**
   * This is a callback method automatically called only 
   * one time when the PApplet application
   * starts as a result of calling PApplet.main
   * ("PAppletClassName"); Defines the initial environment
   * properties of this class/program As setup() is
   *  run only one time when this program starts, all
   * your test methods should be called in this method
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  @Override
  public void setup() {
    super.setup(); // calls the setup() method defined
    park = this; // set the park to the current instance of Jungle
    
    // TODO Call your test methods here
    System.out.println("test1isCloseMethod(): " 
    + test1isCloseMethod()); // prints validity
    System.out.println("test2isCloseMethod(): " 
    + test2isCloseMethod()); // prints validity
    System.out.println("test1DeerScanForThreatMethod() "
        + "" + test1DeerScanForThreatMethod());
    // prints validity
    System.out.println("test2DeerScanForThreatMethod() " 
    + test2DeerScanForThreatMethod());
    // prints validity
    System.out.println("testTigerHopMethod(): " 
    + testTigerHopMethod());
    //prints validity

    // close PApplet display window (No need for the graphic 
    //mode for these tests)
    park.exit();

  }



}
/**
 * File Header comes here
 */


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

/**
 * This class represents a Tiger in the JunglePark application
 *
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range 
  //dimension for scanning the neighborhood for
                                             // food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable 
  //that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A 
  //String that represents the tiger type
  private final int id; // Tiger's id: positive number that 
  //represents the order of the tiger
  private int deerEatenCount; // Number of Deers
  //that the current tiger has eaten so far

  /**
   * Creates a new Tiger object positioned at a
   *  random position of the display window
   * 
   * @param processing PApplet object that represents 
   * the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies 
    //the current tiger
    nextID++; // increments nextID 
    deerEatenCount = 0; // sets deerEatenCount to 0
  }


  /*
   * This method makes the tiger eat the food
   * by hopping to the deer.
   * 
   * @param: Deer food
   * 
   * @return: none
   * 
   */
  
  public void hop(Deer food) {
    if (distance(food) <= SCAN_RANGE) { // checks to see 
      // if the deer close
      mouseReleased(); // releases the mouse
      this.setPositionX(food.getPositionX()); 
      // sets x position equal to deer
      this.setPositionY(food.getPositionY()); 
      // sets y position equal to deer
      for (int i = 0; i < processing.listGUI.size(); i++) { 
        // goes through the list
        if (processing.listGUI.get(i) == food) { 
          // gets the index in the lsit
          processing.listGUI.remove(i); 
          // removes that index from the list
          
        }
      }
      deerEatenCount++; // deerEatenCount increments
    }

  }


  /**
   * Tiger's behavior in the Jungle Park Scans for 
   * food at the neighborhood of the current tiger. If
   * the Tiger founds any deer at its proximity, 
   * it hops on it, and eats it
   *
   */
  @Override
 /**
   * Defines the Tiger's behavior in the Jungle Park
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public void action() {
    // TO DO scan for food (aka deer) and hop on it if any.
    for(int i = 0; i < processing.listGUI.size(); i++) {
      if(processing.listGUI.get(i) instanceof Deer  
          // gets the position of deer
          && this.isClose((Animal)processing.listGUI.get(i) , 
              SCAN_RANGE)) {
        hop((Deer)processing.listGUI.get(i)); 
        // hops to that position
      }
    }
    if(deerEatenCount > 0) 
      // checks to see if deerEatenCount is greater than 0
      displayDeerEatenCount(); 
    // display deerEatenCount
  }
  
  /**
   * Displays the number of eaten deers 
   * if any on the top of the tiger image
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(), 
        this.getPositionY() - this.image.height / 2 - 4);  
    // sets the deerEatenCount on top of the tiger
  }
  
  /*
   * This method gets the total amount
   * of deer eaten
   * 
   * @param: none
   * 
   * @return: integer representing
   * the amount of deer eaten
   * 
   */
  
  public int getDeerEatenCount() {
    return deerEatenCount; // returns the integer of deerEatenCount
  }


}

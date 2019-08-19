
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

public class Deer extends Animal {
  private static final int SCAN_RANGE = 175; // scan range area to 
  //check for a threat in the
                                             // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; 
  // class variable that represents the identifier of the next deer
                                 
  // to be created
  private static final String TYPE = "DR";
  // A String that represents the deer type
  private final int id; 
  // Deer's id: positive number that represents the order of the deer


  // Constructor that creates 
  //a new Deer object positioned at a random 
  //position of the display
  // window
  public Deer(JunglePark processing) {
    super(processing, IMAGE_FILE_NAME);
    // Set Deer identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current Deer
    nextID++;
  }

  // 
  /*
   * Checks if there is a threat (a Tiger for instance) 
   * at the neighborhood
   * scanRange is an integer that represents the 
   * range of the area to be scanned around the animal
   * 
   * @param: int scanRange
   * 
   * @return: boolean representing if there is a threat nearby or not
   * 
   */
  
  public boolean scanForThreat(int scanRange) {
    for(int i = 0; i < processing.listGUI.size(); i++) { 
      // runs through list
      if(processing.listGUI.get(i)instanceof Tiger) { 
        // checks if tiger
        if(this.isClose((Animal)processing.listGUI.get(i), 
            scanRange) == true){ 
          // checks if close
          return true;
        }
    }
  }
    return false;
}

 /*
  * Defines the behavior of a Deer object in the Jungle park
  * there should be no Threat symbol
  * 
  * @param: none
  * 
  * @return: none
  * 
  */
  @Override
  public void action() {
    if(scanForThreat(SCAN_RANGE) == true) { 
      // checks if threat
      this.processing.fill(0); 
      // specify font color: black
      this.processing.text("THREAT!", 
          this.getPositionX(), this.getPositionY() - 
          this.image.height / 2 - 4); 
      // puts threat
    }
    else {      
      System.out.println("No Threat Detected"); 
      // or no threat
    }
  }
  
  /*
   * This method is mainly used for testing purposes
   * 
   * @param: args
   * 
   * @return: none
   * 
   */

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

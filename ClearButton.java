
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Program5_JunglePark2000
// Files: ParkGUI.java, JunglePark.java, AddAnimalButton.java
// Button.java, ClearButton.java, Animal.java, Deer.java
// Tiger.java, JungleParkTests.java
// Course: CS 300, Semester 1, and Freshman
//
// Author: Varun Sudhakaran
// Email: vsudhakaran@wisc.edu
// Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class ClearButton extends Button {

  /*
   * ClearButton constructor takes
   * in the parameters and calls 
   * the super constructor with
   * the appropriate variables.
   * Also sets the variable of label
   * 
   * @param: none 
   * 
   * @return: none
   * 
   */
  
  public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park); // calls the super constructor
    label = "Clear Button"; // sets the label variable
  }
  
  /*
   * mousePressed() method checks if the 
   * mouse is pressed on the clearButton
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  
  public void mousePressed() {
    if(this.isMouseOver()) { // checks if the mouse is over button
      processing.clear(); // clears the window
    }
  }

  /*
   * Main method is used to check
   * for additional tests
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

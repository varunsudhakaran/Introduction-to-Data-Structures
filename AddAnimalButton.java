
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

public class AddAnimalButton extends Button {
  
private String type; // type of the animal to add

/*
 * The AddAnimalButton calls the super class
 * and initializes the type in a lowercase
 * as well as adding the label.
 * 
 * @param: String type, float x, float y, JunglePark park
 * 
 * @return: none
 * 
 */
 
public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park); // calls the superconstructor
    this.type = type.toLowerCase(); // turns the type to lowercase
    this.label = "Add " + type; // makes the label with the add string
}

/*
 *
 * The mouse pressed will trigger what type
 * of animal must be added to the screen. If the
 * button is tiger, a tiger will be added, or if 
 * it is a deer, then a deer will be added.
 * 
 * @param: none
 * 
 * @return: none
 * 
 *
 */

@Override
public void mousePressed() {
  if (isMouseOver()) { // checks if mouse is over
    switch (type) { // uses switch to check type
      case "tiger": // checks if type is tiger
        //TODO create a new Tiger and add it to the JunglePark
        Tiger t = new Tiger(processing); // initializes object tiger
        processing.listGUI.add(t); // adds tiger to list
        break; // breaks program
      case "deer": // checks if type is a deer
        //TODO create a new Deer and add it to the JunglePark
        Deer d = new Deer(processing); // initializes object deer
        processing.listGUI.add(d); // adds deer to list 
        break; // breaks program
    }
  }
}


  public static void main(String[] args) {
    // TODO Auto-generated method stub
  }

}

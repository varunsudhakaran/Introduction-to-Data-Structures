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

// TODO Add file header
// TODO Add javadoc interface header

/*
 * ParGUI interface basically culminates all 
 * of the methods that is implemented in all 
 * the classes to function properly.
 * 
 * @param: none
 * 
 * @return: none
 * 
 */

public interface ParkGUI {
  public void draw(); // draws a ParkGUI object 
  //(either an animal or a button) to the display window

  public void mousePressed(); // called each time the mouse is Pressed

  public void mouseReleased(); // called each time the mouse is Pressed

  public boolean isMouseOver(); // checks whether 
  //the mouse is over a ParkGUI object

}
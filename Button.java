

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



// This a super class for any Button that can 
//be added to a PApplet application
// This class implements the ParkGUI interface
// TODO You MUST comment well this code
// TODO ADD File header, Javadoc class header, Javadoc method header 
//to every method, and in-line commenting

public class Button implements ParkGUI {
  private static final int WIDTH = 85; 
  // Width of the Button
  private static final int HEIGHT = 32; 
  // Height of the Button
  protected JunglePark processing; 
  // PApplet object where the button will be displayed
  private float[] position; 
  // array storing x and y positions of the Button with respect to 
                            
  // the display window 
  protected String label;   
  // text/label that represents the button
  
  /*
   * Sets all the Buttons with the position
   * and the park in which they are added
   * 
   * @param: none
   * 
   * @return: none
   * 
   */

  public Button(float x, float y, JunglePark processing) {
    this.processing = processing; // sets the variable to processing
    this.position = new float[2]; // sets the position
    this.position[0] = x; // sets the position of first position
    this.position[1] = y; // sets the position of second position
    this.label = "Button"; // makes label "Button"
  }

  
  @Override
  /*
   * The method draws the button into
   * the graphical window
   * 
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver()) // checks if the mouse is over
      processing.fill(100); // set the fill color 
    //to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray 
    //otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, 
        position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1]
            + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); 
    // display the text of the current button
  }

  @Override
  /*
   *
   * This mouse pressed method essentially
   * checks if the mouse is pressed and prints
   * a message
   * 
   * @param: none
   * 
   * @return: none
   *
   */
  public void mousePressed() { 
    if (isMouseOver()) // checks if the mouse is over
      System.out.println("A button was pressed."); 
    // prints message
  }

  @Override
  /*
   *
   * This mouse released method essentially
   * checks if the mouse is released
   * 
   * @param: none
   * 
   * @return: none
   *
   */
  public void mouseReleased() {}

  @Override
  /*
   *
   * Checks if the mouse is over
   * the button
   * 
   * @param: none
   * 
   * @return: none
   *
   */
  public boolean isMouseOver() {
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    return false;
  }
}
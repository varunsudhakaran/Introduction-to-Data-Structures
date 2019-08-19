/**
 * File Header must go here
 */
import java.util.Random;

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
 * This class represents an animal in the Jungle Park application It 
 * implements the interface
 * ParkGUI
 *
 * @author Mouna Kacem
 */
public class Animal implements ParkGUI {

  private static Random randGen = new Random();
  // Generator of random numbers
  protected String label; 
  // represents the animal's identifier
  // Fields defined to draw the animal in the application 
  //display window
  protected JunglePark processing; 
  // PApplet object that represents the display window
  protected PImage image; 
  // animal's image

  private float[] position; 
  // animal's position in the display window
  // Usage: position[0: x-coordinate, or 1: y-coordinate]
  private boolean isDragging; 
  // indicates whether the animal is being dragged or not


  /**
   * Creates a new Animal object positioned at a given position 
   * of the display window
   * 
   * @param processing    
   * PApplet object that represents the display window
   * @param positionX     
   * x-coordinate of the animal's image in the display window
   * @param positionY    
   *  y-coordinate of the animal's image in the display window
   * @param imageFileName filename of the animal image
   * 
   * @return: none
   * 
   */
  public Animal(JunglePark processing, float positionX, float positionY, 
      String imageFileName) {

    // Set Animal drawing parameters
    this.processing = processing; // set the 
    //PApplet Object where the animal will be drawn
    this.position = new float[] {positionX, positionY}; 
    // sets the position of the animal object
    this.image = processing.loadImage(imageFileName); 
    // sets the image
    isDragging = false; 
    // initially the animal is not dragging
  }

  /**
   * Creates a new Animal object positioned at a 
   * random position of the display window
   * 
   * @param processing    PApplet object that 
   * represents the display window
   * @param imageFileName filename of the 
   * animal image
   * 
   * @return: none
   * 
   */
  public Animal(JunglePark processing, String imageFileName) {
    this(processing, (float) randGen.nextInt(processing.width), 
        // creates a random position
        Math.max((float) randGen.nextInt(processing.height), 100), 
        imageFileName); // makes the animal here
  }

  /**
   * Draws the animal to the display window. 
   * It sets also its position to the mouse position if the
   * tiger is being dragged (i.e. if its isDragging 
   * field is set to true).
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  @Override
  public void draw() {
    // if the tiger is dragging, set its position to the
    //mouse position with respect to the display
    // window (processing) dimension
    if (this.isDragging) {
      if (this.processing.mouseX < 0) // mouse outside the screen
        this.position[0] = 0; // sets the first index of position
      else if (this.processing.mouseX > this.processing.width) 
        // mouse outside the screen
        this.position[0] = this.processing.width; 
      // sets the first index of position to width
      else
        this.position[0] = this.processing.mouseX; 
      // sets the first index of position to the mouseX

      if (this.processing.mouseY < 0)
        // mouse outside the screen
        this.position[1] = 0; 
      // sets the second index of position
      else if (this.processing.mouseY > this.processing.height)
        // mouse outside the screen
        this.position[1] = this.processing.height; 
      // sets the second index to the height
      else
        this.position[1] = this.processing.mouseY; 
      // sets the second index to the mouseY
    }

    // draw the tiger at its current position
    this.processing.image(this.image, 
        this.position[0], position[1]); 
    // gets the image 
    // display label
    displayLabel(); // calls displayLabel()
    action(); // calls action()
  }


  /**
   * display's the Tiger object label on the application window screen
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  private void displayLabel() {
    this.processing.fill(0); // specify font color: black
    this.processing.text(label, this.position[0], this.position[1] 
        + this.image.height / 2 + 4);// display
                                                                                                // label
                                                                                                // //
                                                                                                // text
  }

  /**
   * Checks if the mouse is over the given tiger object
   * 
   * @param tiger reference to a given Tiger object
   * @return true if the mouse is over the given tiger object, 
   * false otherwise
   */
  @Override
  public boolean isMouseOver() {
    int tigerWidth = image.width; // image width
    int tigerHeight = image.height; // image height

    // checks if the mouse is over the tiger
    if (processing.mouseX > position[0] - tigerWidth / 2
        && processing.mouseX < position[0] + tigerWidth / 2
        && processing.mouseY > position[1] - tigerHeight / 2
        && processing.mouseY < position[1] + tigerHeight / 2) { 
      // checks if the mouse of x and y are hitting the button
      return true;
    }
    return false;
  }

  @Override
  
  /*
   * This method checks if the 
   * mouse is pressed on the button 
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public void mousePressed() {
    if (isMouseOver()) // checks if mouse is over
      isDragging = true; // sets is Dragging to true
  }

  @Override
  /*
   * This method checks if the mouse
   * is released.
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public void mouseReleased() {
    isDragging = false; // sets isDragging to false
  }

  /**
   * This method is an accessor to getting
   * the label
   * 
   * @param: none
   * 
   * @return the label that represents the tiger's identifier
   * 
   */
  public String getLabel() {
    return label; // returns label
  }


  /**
   * This method is an accessor to getting
   * an image
   * 
   * @param: none
   * 
   * @return the image of type PImage of the tiger object
   */
  public PImage getImage() {
    return image; // returns image
  }


  /**
   * This method is an accessor to getting
   * Position X
   * 
   * @param: none
   * 
   * @return the X coordinate of the animal position
   */
  public float getPositionX() {
    return position[0]; // returns x
  }

  /**
   * This method is an accessor
   * to getting the Position Y
   * 
   * @param: none
   * 
   * @return the Y coordinate of the animal position
   */
  public float getPositionY() {
    return position[1]; // returns y
  }


  /**
   * This method is an mutator to getting 
   * to setting Position X
   * 
   * @param position the XPosition to set
   * 
   * @return: none
   * 
   */
  public void setPositionX(float position) {
    this.position[0] = position; // sets position x
  }

  /**
   * This method is an mutator to getting 
   * to setting Position Y
   * 
   * @param position the YPosition to set
   * 
   * @return: none
   * 
   */
  public void setPositionY(float position) {
    this.position[1] = position; // sets position y
  }

  /**
   * 
   * This method checks to see if animal is
   * getting dragged
   * 
   * @param: none
   * 
   * @return true if the animal is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging; // returns isDragging
  }

  /**
   * Computes the euclidean distance between the current animal 
   * and another one
   * 
   * @param otherAnimal reference to another animal
   * @return distance between the current animal 
   * and otherAnimal
   */
  public double distance(Animal otherAnimal) {
    return Math.sqrt(Math.pow(this.getPositionX() 
        - otherAnimal.getPositionX(), 2)
        + Math.pow(this.getPositionY() 
            - otherAnimal.getPositionY(), 2)); // returns
    // Euclidean distance
  }

  /**
   * Defines the behavior of the current animal 
   * in the jungle park
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public void action() {
    // This method should be overridden by a subclasse
  }

  /*
   * This method checks to see if one animal
   * is close to another animal.
   * 
   * @param: Animal otherAnimal, int range
   * 
   * @return: boolean variable representing if the
   * animal is close or not
   * 
   */
  public boolean isClose(Animal otherAnimal, int range) {
    if (distance(otherAnimal) <= range) {
      return true;
    } else {
      return false;
    }
  }

}

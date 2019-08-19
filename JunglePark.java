/**
 * File header comes here
 *
 */
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

/**
 * Class Header comes here
 * 
 * @author Mouna Kacem
 *
 */
public class JunglePark extends PApplet {
  private PImage backgroundImage; 
  // PImage object that represents the background image
  protected ArrayList<ParkGUI> listGUI; 
  // ArrayList storing the current graphical objects (animals
                                        
  // present
  // in the Jungle Park and buttons)


  /**
   * CallBack method Defines initial 
   * environment properties such as screen size and to load
   * background images and fonts as 
   * the program starts Initializes the 
   * backgroundImage and listGUI
   * instance fields.
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  @Override
  public void setup() {
    this.getSurface().setTitle("Jungle Park"); 
    // Displays text in the title of the display window
    this.textAlign(PApplet.CENTER, PApplet.CENTER); 
    // Sets the current alignment for drawing text
                                                    
    // to CENTER
    this.imageMode(PApplet.CENTER); 
    // Sets the location from which images are drawn to CENTER
    this.rectMode(PApplet.CORNERS); // Sets the location from 
    //which rectangles are drawn.
    // rectMode(CORNERS) interprets the first 
    //two parameters of rect() method as the location of one
    // corner, and the third and fourth 
    //parameters as the location of the opposite corner.
    // rect() method draws a rectangle to the 
    //display window
    this.focused = true; 
    // Confirms that our Processing program is 
    //"focused," meaning that
    // it is active and will accept mouse or keyboard input.
    backgroundImage = this.loadImage("images/background.png"); 
    // load the background image

    listGUI = new ArrayList<ParkGUI>(); 
    // create the listGUI ArrayList that would store all the
    // graphic objects (animals and buttons) 
    //that would be drawn on the display window
    AddAnimalButton a1 = new AddAnimalButton("Tiger", 43, 16, this); 
    // adds an animal button of
    // tiger that is at (43,16) position
    listGUI.add(a1); // a1 is added to the list
    AddAnimalButton a2 = new AddAnimalButton("Deer", 129, 16, this); 
    // adds an animal button of
    // deer that is at (129,16) position
    listGUI.add(a2); // a2 is added to the list
    ClearButton c = new ClearButton(215, 16, this); 
    // adds a clear button 
    // that is at (215, 16) position
    listGUI.add(c); // c is added to the list
  }

  /**
   * Sets the size of the application display window
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  @Override
  public void settings() {
    size(800, 632); // sets the size of the display window 
    //to 800 x 632 pixels
  }


  /**
   * Callback method called in an infinite loop. 
   *It draws the Jungle Park's window display
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  @Override
  public void draw() {
    // Set the color used for the background 
    //of the Processing window
    this.background(245, 255, 250);
    // Set the mint cream color background
    this.image(backgroundImage, this.width / 2, this.height / 2); 
    // draw the background image at
    // the center of the display window
    // traverse the tigers array and draw each stored tiger
    for (int i = 0; i < listGUI.size(); i++) 
      // runs through the list
      listGUI.get(i).draw(); 
    // draws each graphical object in the list
  }

  /**
   * Callback method called each time the user presses the mouse
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  @Override
  public void mousePressed() {
    // traverse listGUI and call mousePressed() 
    //of the first graphical object which the mouse is
    // over
    for (int i = 0; i < listGUI.size(); i++) 
      // runs through the list
      if (listGUI.get(i).isMouseOver()) { 
        // checks if mouse is over
        listGUI.get(i).mousePressed(); 
        // presses mouse at that index
        break; 
        // breaks the program
      }
  }

  /**
   * Callback method called each time the mouse is released
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  @Override
  public void mouseReleased() {
    // traverse listGUI and call mouseReleased() 
    //method defined for every graphic object
    for (int i = 0; i < listGUI.size(); i++) 
      // runs through the list
      listGUI.get(i).mouseReleased(); 
    // releases the mouse at that index
  }

  /**
   * Callback method called each time the user presses a key
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  @Override
  public void keyPressed() {

    switch (Character.toUpperCase(this.key)) { 
      // switches the uppercase of type
      case 'T': // checks if t key is pressed
        listGUI.add(new Tiger(this)); // adds tiger to list
        break; // breaks the program
      case 'D': // checks if d key is pressed
        listGUI.add(new Deer(this)); // adds deer to list
        break; // breaks the program
      case 'R': // checks if r key is pressed
        for (int i = 0; i < listGUI.size(); i++) {
          if (listGUI.get(i) instanceof Animal 
              && listGUI.get(i).isMouseOver()) { 
            // remove an animal from the Jungle Park if 
            //the mouse is over it
            listGUI.remove(i);// traverse the listGUI
            //list and consider only animal objects to be removed if any
         // remove the first animal which the mouse is 
            //over it while the r-key is pressed
            break; // breaks the program
          }
        }
    }
    // Executes the same function but with lowercase
  }

  /**
   * Removes all the animals from the park
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public void clear() {
    for (int i = 0; i < listGUI.size(); i++) { 
      // runs through list
      if (listGUI.get(i) instanceof Animal) { 
        // checks if animal
        listGUI.remove(i); 
        // removes the animal
        i--; 
        // decrements index
      }
    }
  }



  /**
   * This main method starts the application
   * 
   * @param args
   * 
   * @return: none
   * 
   */
  public static void main(String[] args) {
    // starts the application (calls PApplet main() 
    //method with the name
    // of the PApplet class to run as parameter)
    PApplet.main("JunglePark");
  }
}

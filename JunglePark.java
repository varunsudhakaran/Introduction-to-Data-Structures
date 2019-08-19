import java.util.Random;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////

//

// Title: Program1_AuditableBanking

// Files: AuditableBanking.java, AuditbaleBanking

// Course: CS 300, Semester 1, and Freshman

//

// Author: Varun Sudhakaran

// Email: vsudhakaran@wisc.edu

// Lecturer's Name: Professor Gary Dahl

//

//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////

//

// Partner Name: Steve Hizmi

// Partner Email: shizmi@wisc.edu

// Partner Lecturer's Name: Professor Gary Dahl

//

// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:

// _X__ Write-up states that pair programming is allowed for this assignment.

// _X__ We have both read and understand the course Pair Programming Policy.

// _X__ We have registered our team prior to the team registration deadline.

//

///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////

//

// Students who get help from sources other than their partner must fully

// acknowledge and credit those sources of help here. Instructors and TAs do

// not need to be credited here, but tutors, friends, relatives, room mates,

// strangers, and others do. If you received no outside help from either type

// of source, then please explicitly indicate NONE.

//

// Persons: Matthew Chiang helped me with the keyPressed() method.

//

// Online Sources: none

//

/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////



public class JunglePark {



  private static PApplet processing; // PApplet object that represents the graphic

  // interface of the JunglePark application

  private static PImage backgroundImage; // PImage object that represents the

  // background image

  private static Tiger[] tigers; // array storing the current tigers present

  // in the Jungle Park

  private static Random randGen; // Generator of random numbers



  public static void main(String[] args) {

    // TODO Auto-generated method stub

    Utility.startApplication();

  }



  /**
   *
   * 
   * 
   * // initialize the processing field to the one passed into // Set the color used for the
   * background of the Processing window // Mint cream color // initialize and load the image of the
   * background // Draw the background image at the center of the screen // create a Random object
   * and store its reference in randGen
   * 
   * 
   * @param processingObj
   * 
   *                      represents a reference to the graphical interface of the
   * 
   *                      application
   * 
   * @return none
   * 
   */

  public static void setup(PApplet processingObj) {

    processing = processingObj;
    processing.background(245, 255, 250);

    backgroundImage = processing.loadImage("images/background.png");


    processing.image(backgroundImage, processing.width / 2, processing.height / 2);

    tigers = new Tiger[8];

    randGen = new Random();

    tigers[0] = new Tiger(processing, (float) randGen.nextInt(processing.width),

        (float) randGen.nextInt(processing.height));

    tigers[0].draw();

  }

  /**
   *
   * // Set the color used for the background of the Processing window // Mint cream color //
   * initialize and load the image of the background // Draw the background image at the center of
   * the screen // width [resp. height]: System variable of the processing library that stores //
   * the width [resp. height] of the display window. // Draws each element in tigers array if its
   * not null // Draws each element in tigers array if its not null
   * 
   * 
   * @param none
   * 
   * @return none
   * 
   */


  public static void update() {



    processing.background(245, 255, 250);

    backgroundImage = processing.loadImage("images/background.png");


    processing.image(backgroundImage, processing.width / 2, processing.height / 2);

    for (int i = 0; i < tigers.length; i++) {

      if (tigers[i] != null) {

        tigers[i].draw();

      }

    }
  }

  /*
   * // gets tiger image width // gets tiger image height // sets range for mouse on the x axis //
   * sets range for mouse on the y axis // if mouse is in range, return true // if mouse is not in
   * range, return false
   * 
   * @param: tiger object
   * 
   * @return: boolean
   * 
   * 
   */


  public static boolean isMouseOver(Tiger tiger) {



    int width = tiger.getImage().width;

    int height = tiger.getImage().height;



    if (processing.mouseX >= tiger.getPositionX() - width / 2

        && processing.mouseX <= tiger.getPositionX() + width / 2) {



      if (processing.mouseY >= tiger.getPositionY() - height / 2

          && processing.mouseY <= tiger.getPositionY() + height / 2) {



        return true;

      }

    }



    return false;

  }

  /*
   * // goes thru each element, and if not null and mouse is over tiger, dragging is // set to true
   * // if mouse is not in range of certain tiger, dragging is set to false
   * 
   * @param: none
   * 
   * @return: none
   */



  public static void mouseDown() {



    for (int i = 0; i < tigers.length; i++) {

      if (tigers[i] != null) {

        if (isMouseOver(tigers[i]) == true) {

          tigers[i].setDragging(true);

        }



        else {



          tigers[i].setDragging(false);

        }



      }

    }

  }

  /*
   * // goes through each element in tigers array, if tiger is not null, dragging is // set to false
   * 
   * @param: none
   * 
   * @return: none
   */


  public static void mouseUp() {



    for (int i = 0; i < tigers.length; i++) {

      if (tigers[i] != null) {

        tigers[i].setDragging(false);

      }

    }

  }

  /*
   * // if element is created, keepGoing is set to false to stop the keyPressed // method // if
   * tiger is null and keepGoing is true, a tiger image is created // if tiger is not null,
   * isMouseOver returns true or false if mouse is over // tiger, then that tiger is set to null to
   * delete it
   * 
   * @param: none
   * 
   * @return: none
   * 
   */

  public static void keyPressed() {



    boolean keepGoing = true;



    if (processing.key == 't' || processing.key == 'T') {



      for (int i = 0; i < tigers.length; i++) {

        if (tigers[i] == null && keepGoing == true) {

          tigers[i] = new Tiger(processing, (float) randGen.nextInt(processing.width),

              (float) randGen.nextInt(processing.height));

          tigers[i].draw();

          keepGoing = false;

          if (keepGoing = false) {

            break;

          }

        }

      }

    }


    if (processing.key == 'r' || processing.key == 'R') {

      for (int i = tigers.length - 1; i >= 0; i--) {

        if (tigers[i] != null) {

          if (isMouseOver(tigers[i]) == true) {

            tigers[i] = null;

          }

        }

      }

    }
  }
}


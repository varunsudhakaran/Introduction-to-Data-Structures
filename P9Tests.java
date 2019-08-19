////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program9_BadgersSettleDown
//Files: Badger.java, Sett.java, P9Tests.java, BadgersSettleDown.java
//Course: CS 300, Semester 1, and Freshman
//
//Author: Varun Sudhakaran
//Email: vsudhakaran@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * P9 Tests class is a class that tests 
 * the Badger Class and the Sett Class for
 * validity.
 * 
 * @author varunsudhakaran 
 *
 */

public class P9Tests {
  
  /**
   * runAllBadgerTests() runs all of the 
   * Badger class tests
   * 
   * @param: none
   * 
   * @return: true if passes all tests,
   * false if none of the tests
   * pass
   * 
   */

  public static boolean runAllBadgerTests() {
    // returns true when all Badger tests pass
    if (testBadgerConstructor() 
        && testLeftLowerNeighbor() 
        && testRightLowerNeighbor()
        && testGetSize()) {
      // checks if the tests for 
      // Badger class are all true
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }

  /**
   * testBadgerConstructor() tests
   * the Badger Constructor
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */
  
  public static boolean testBadgerConstructor() {
    Badger b1 = new Badger(10);
    // creates Badger
    Badger b2 = new Badger(11);
    // creates Badger
    Badger b3 = new Badger(9);
    // creates Badger
    if ((b1.getSize() == 10 && b2.getSize() == 11) 
        && b1.getLeftLowerNeighbor() == null
        && b2.getRightLowerNeighbor() == null) {
      // checks if the size and the neighbors 
      // are true
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }
  
  /**
   * testLeftLowerNeighbor() tests
   * the lower left neighbor of the Badger
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */

  public static boolean testLeftLowerNeighbor() {
    Badger b1 = new Badger(10);
    // creates Badger
    Badger b2 = new Badger(11);
    // creates Badger
    Badger b3 = new Badger(9);
    // creates Badger
    b1.setLeftLowerNeighbor(b3);
    if (b1.getLeftLowerNeighbor().equals(b3)) {
      // checks if the neighbors are
      // right
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }
  
  /**
   * testLeftLowerNeighbor() tests
   * the lower right neighbor of the Badger
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */

  public static boolean testRightLowerNeighbor() {
    Badger b1 = new Badger(10);
    // creates Badger
    Badger b2 = new Badger(11);
    // creates Badger
    Badger b3 = new Badger(9);
    // creates Badger
    b1.setRightLowerNeighbor(b2);
    if (b1.getRightLowerNeighbor().equals(b2)) {
      // checks to see if the neighbors
      // are right
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }

  /**
   * testGetSize() tests
   * the size of each Badger
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */

  public static boolean testGetSize() {
    Badger b1 = new Badger(10);
    // creates Badger
    Badger b2 = new Badger(11);
    // creates Badger
    Badger b3 = new Badger(9);
    // creates Badger
    if (b1.getSize() == 10 && b2.getSize() == 11) {
      // checks if the sizes are right
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }

  /**
   * runAllSettTests() runs all of the 
   * Badger class tests
   * 
   * @param: none
   * 
   * @return: true if passes all tests,
   * false if none of the tests
   * pass
   * 
   */

  public static boolean runAllSettTests() {
    // returns true when all Sett tests pass
    if (testSettConstructor() && testisEmpty() 
        && testLargestBadger() && testGetHeight()
        && testGetAllBadgers() && testFindBadger() 
        && testCountBadger() && testClear()
        && testSettleBadger() && testGetTopBadger()) {
      // checks if all the Sett tests pass
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }

  /**
   * testSettContructor() tests
   * Sett Constructor
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */

  
  public static boolean testSettConstructor() {
    Sett s = new Sett();
    // creates a sett
    if (s.isEmpty()) {
      // checks if sett is empty
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }
  
  /**
   * testisEmpty() tests
   * if the Sett is empty or full
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */


  public static boolean testisEmpty() {
    Sett s = new Sett();
    // creates a sett
    s.settleBadger(5);
    // settles Badger
    s.settleBadger(6);
    // settles Badger
    s.settleBadger(7);
    // settles Badger
    s.settleBadger(4);
    // settles Badger
    s.settleBadger(8);
    // settles Badger
    s.settleBadger(9);
    // settles Badger
    if (!s.isEmpty()) {
      // checks if sett is full
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }

  /**
   * testLargestBadger() tests
   * if program returns the largest
   * Badger 
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */

  
  public static boolean testLargestBadger() {
    Sett s = new Sett();
    // creates a sett
    s.settleBadger(5);
    // settles Badger
    s.settleBadger(6);
    // settles Badger
    s.settleBadger(7);
    // settles Badger
    s.settleBadger(4);
    // settles Badger
    s.settleBadger(8);
    // settles Badger
    s.settleBadger(9);
    // settles Badger
    if (s.getLargestBadger().getSize() == 9) {
      // checks to see if the largest badger
      // equals 9
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }
  
  /**
   * testGetSize() tests
   * the height of the tree
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */


  public static boolean testGetHeight() {
    Sett s = new Sett();
    // creates a sett
    s.settleBadger(5);
    // settles Badger
    s.settleBadger(6);
    // settles Badger
    s.settleBadger(7);
    // settles Badger
    s.settleBadger(4);
    // settles Badger
    s.settleBadger(8);
    // settles Badger
    s.settleBadger(9);
    // settles Badger
    if (s.getHeight() == 5) {
      // checks to see if the
      // height is correct
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }
  
  /**
   * testGetAllBadgers() tests 
   * if the program gets all 
   * badgers in ascending order
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */


  public static boolean testGetAllBadgers() {
    Sett s = new Sett();
    // creates a sett
    s.settleBadger(5);
    // settles Badger
    s.settleBadger(6);
    // settles Badger
    s.settleBadger(7);
    // settles Badger
    s.settleBadger(4);
    // settles Badger
    s.settleBadger(8);
    // settles Badger
    s.settleBadger(9);
    // settles Badger
    List<Badger> list;
    // initializes list
    list = s.getAllBadgers();
    // list equals the all of the badgers
    for (int i = 0; i < list.size(); i++) {
      // runs through the list
      if (list.get(i).getSize() != i + 4) {
        // checks to see if 
        // badgers are not ascending order
        return false;
        // returns false
      }
    }
    return true;
    // returns true
  }
  
  /**
   * testFindBadger() checks 
   * to see if the program 
   * can find the specific badger
   * at this size
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */


  public static boolean testFindBadger() {
    try {
      Sett s = new Sett();
      // creates a sett
      s.settleBadger(5);
      // settles Badger
      s.settleBadger(6);
      // settles Badger
      s.settleBadger(7);
      // settles Badger
      s.settleBadger(4);
      // settles Badger
      s.settleBadger(8);
      // settles Badger
      s.settleBadger(9);
      // settles Badger
      if (s.findBadger(5).getSize() != 5) {
        // checks to see if program
        // can find the Badger with size 5
        return false;
        // returns false
      } else {
        return true;
        // retuns true
      }
    } catch (Exception e) {
      // catches Exception
      return false;
      // returns false
    }
  }

  /**
   * testCountBadger() checks to see
   * if the program counts the right 
   * amount of badgers
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */
  
  public static boolean testCountBadger() {
    Sett s = new Sett();
    // creates a sett
    s.settleBadger(7);
    // settles Badger
    s.settleBadger(6);
    // settles Badger
    s.settleBadger(5);
    // settles Badger
    s.settleBadger(4);
    // settles Badger
    s.settleBadger(8);
    // settles Badger
    s.settleBadger(9);
    // settles Badger
    if (s.countBadger() == 6) {
      // checks to see if the program 
      // can count the badgers
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }

  /**
   * testClear() checks to see
   * if the progam clears the sett.
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */
  
  public static boolean testClear() {
    Sett s = new Sett();
    // creates a sett
    s.settleBadger(7);
    // settles Badger
    s.settleBadger(6);
    // settles Badger
    s.settleBadger(5);
    // settles Badger
    s.settleBadger(4);
    // settles Badger
    s.settleBadger(8);
    // settles Badger
    s.settleBadger(9);
    // settles Badger
    s.clear();
    // clears the sett
    if (s.isEmpty()) {
      // checks to see if
      // sett is empty
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }
  
  /**
   * testSettleBadger() checks to 
   * see if the badgers are in the
   * right position
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */

  public static boolean testSettleBadger() {
    Sett s = new Sett();
    // creates a sett
    s.settleBadger(5);
    // settles Badger
    s.settleBadger(6);
    // settles Badger
    s.settleBadger(4);
    // settles Badger
    s.settleBadger(7);
    // settles Badger
    s.settleBadger(3);
    // settles Badger
    if (s.getTopBadger().getSize() != 5 
        && s.getTopBadger().getLeftLowerNeighbor().getSize() != 4
        && s.getTopBadger().getRightLowerNeighbor().getSize() != 6
        && s.getTopBadger().getLeftLowerNeighbor()
        .getLeftLowerNeighbor().getSize() != 3
        && s.getTopBadger().getRightLowerNeighbor()
        .getRightLowerNeighbor().getSize() != 7) {
      // checks to see if the size and neighbors
      // match correctly
      return false;
      // returns false
    } else {
      return true;
      // returns true
    }
  }
  
  /**
   * testGetTopBadger() checks 
   * to see if the program gets
   * the right topBadger.
   * 
   * @param: none
   * 
   * @return: true if passes the test,
   * false if you fail the test
   * 
   */

  public static boolean testGetTopBadger() {
    Sett s = new Sett();
    // creates a sett
    s.settleBadger(5);
    // settles Badger
    s.settleBadger(6);
    // settles Badger
    s.settleBadger(4);
    // settles Badger
    if (s.getTopBadger().getSize() == 5) {
      // checks to see if the topBadger
      // size matches correctly
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }

  /**
   * The main method is used for 
   * testing purposes
   * 
   * @param args
   * 
   * @return: none
   * 
   */
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int fails = 0;
    // initializes fails to 0
    if (!runAllBadgerTests()) {
      // checks if runAllBadgerTests is false
      fails++;
      // increments fails
      System.out.println("runAllBadgerTests fails!");
      // prints message
    }
    if (!runAllSettTests()) {
      // checks if runAllSettTests is false
      fails++;
      // increments fails
      System.out.println("runAllSettTests fails!");
      // prints message
    }
    if (fails == 0) {
      // checks if fails is 0
      System.out.println("All tests pass!");
      // prints message
    }

  }

}

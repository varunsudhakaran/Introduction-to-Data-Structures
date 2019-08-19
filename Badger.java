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


/**
 * This class represents a Sett, where a group of Badgers live together. 
 * Each Sett is orgThis class represents a Badger which is designed to 
 * live in a Sett. Each Badger object represents a single node within 
 * a BST (known as a Sett).anized as a BST of Badger nodes.
 * 
 * @author varunsudhakaran 
 *
 */
public class Badger extends java.lang.Object {

  private Badger leftLowerNeighbor;
  // private field of leftLowerNeighbor
  private Badger rightLowerNeighbor;
  // private field of rightLowerNeighbor
  private int size;
  // private field of size

  /**
   * Constructor creates a new 
   * Badger with specified size.
   * 
   * @param size
   * 
   * @return: none
   * 
   */
  public Badger(int size) {
    this.size = size;
    // sets size
    this.leftLowerNeighbor = null;
    // sets leftLowerNeighbor
    this.rightLowerNeighbor = null;
    // sets rightLowerNeighbor
  }

  /**
   * getLeftLowerNeighbor() retrieves 
   * neighboring badger that is smaller 
   * than this one.
   * 
   * @param : none
   * 
   * @return: The left lower 
   * neighbor of current badger.
   * 
   */
  
  public Badger getLeftLowerNeighbor() {
    return leftLowerNeighbor;
    // returns leftLowerNeighbor
  }

  /**
   * getRightLowerNeighbor() retrieves 
   * neighboring badger that is larger 
   * than this one.
   * 
   * @param : none
   * 
   * @return: The right lower 
   * neighbor of current badger.
   * 
   */
  
  public Badger getRightLowerNeighbor() {
    return rightLowerNeighbor;
    // returns rightLowerNeighbor
  }

  /**
   * getSize() retrieves the 
   * size of this badger.
   * 
   * @param: none
   * 
   * @return: The size of current badger.
   * 
   */
  
  public int getSize() {
    return size;
    // returns size
  }

  /**
   * setLeftLowerNeighbor() changes this badger's 
   * lower left neighbor.

   * @param badger - The new left lower 
   * neighbor of current badger.
   * 
   * @return: none
   * 
   */
  
  public void setLeftLowerNeighbor(Badger badger) {
    this.leftLowerNeighbor = badger;
    // sets leftLowerNeighbor to badger
  }
  
  /**
   * setRightLowerNeighbor() changes this badger's 
   * lower right neighbor.

   * @param badger - The new right lower 
   * neighbor of current badger.
   * 
   * @return: none
   * 
   */

  public void setRightLowerNeighbor(Badger badger) {
    this.rightLowerNeighbor = badger;
    // sets rightLowerNeighbor to badger
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

  }

}

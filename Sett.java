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
 * This class represents a Sett, where a group of Badgers live together. 
 * Each Sett is organized as a BST of Badger nodes.
 * 
 * @author varunsudhakaran 
 *
 */

public class Sett extends java.lang.Object {

  private Badger topBadger;
  // creates a field for the root badger
  
  /**
   * Sett() constructs an empty Sett.
   * 
   * @param: none
   * 
   * @return: none
   * 
   */

  public Sett() {
    this.topBadger = null;
    // makes the sett empty
  }

  /**
   * clear() empties this Sett, 
   * to no longer contain any Badgers.
   * 
   * @param: none 
   * 
   * @return: none
   * 
   */
  public void clear() {
    topBadger = null;
    // sets the root node to null
  }

  /**
   * countBadger() counts how many 
   * Badgers live in this Sett.
   * 
   * @param: none
   * 
   * @return: the number of Badgers 
   * living in this Sett.
   * 
   */
  public int countBadger() {
    int ctr = 0;
    // sets ctr to 0
    if (topBadger == null) {
      // checks if the root is null
      return ctr;
      // returns the ctr
    }
    return countHelper(topBadger);
    // recurses this method with the root node
  }

  /**
   * countHelper() is a recursive helper method is used to 
   * help count the number of Badgers in this Sett.

   * @param: current - The current Badger that is the 
   * root of a (sub) tree that we are counting the 
   * number of Badgers within.
   * 
   * @return: the number of Badgers living in the Sett 
   * rooted at the current Badger.
   * 
   */
  private int countHelper(Badger current) {
    int ctr = 0; 
    // initializes ctr to 0
    if (current == null) {
      // checks if current is null
      return ctr;
      // returns ctr
    } else {
      ctr++;
      // increments ctr
      ctr += countHelper(current.getLeftLowerNeighbor());
      // increments ctr with the left recursive method
      ctr += countHelper(current.getRightLowerNeighbor());
      // increments ctr with the right recursive method
      return ctr;
      // return ctr
    }
  }

  /**
   * findBadger() finds a Badger 
   * of a specified size in this Sett.
   * 
   * @param: size - The size of the Badger 
   * object to search for and return.
   *
   * @return: The Badger found with the specified size.
   * 
   * @throws java.util.NoSuchElementException - When there 
   * is no Badger in this Sett with the specified size.
   */
  public Badger findBadger(int size) 
      throws java.util.NoSuchElementException {
    return findHelper(topBadger, size);
    // recurses the findHelper method with the
    // root and the size
  }

  /**
   * findHelper() is a recursive helper 
   * method is used to help find a 
   * Badger within this Sett.
   * 
   * @param: current - The current Badger that is the root 
   * of a (sub) tree that we 
   * are searching for a Badger 
   * with the specified size within.
   * 
   * @param: size - The size of the Badger object 
   * to search for and return.
   * 
   * @return: The Badger found with 
   * the specified size.
   * 
   * @throws java.util.NoSuchElementException - When there is no 
   * Badger in this Sett with the specified size.
   */
  private Badger findHelper(Badger current, int size) 
      throws java.util.NoSuchElementException {
    if (current == null) {
      // checks if current is null
      throw new NoSuchElementException(
          "WARNING: failed to find a " 
      + "badger with size " + size + " in the sett");
      // throws exception
    } else {
      if (size < current.getSize()) {
        // checks if size is less than current size
        return findHelper(current.getLeftLowerNeighbor(), size);
        // recurses left
      } else if (size == current.getSize()) {
        // checks if size is equal to current size
        return current;
        // returns current
      } else {
        return findHelper(current.getRightLowerNeighbor(), size);
        // recurses right
      }
    }
  }

  /**
   * getAllBadgers() Gets all Badgers living in the Sett as a list in 
   * ascending order of their size: smallest one in the front 
   * (at index zero), through the largest one at the end 
   * (at index size-1).
   * 
   * @param: none
   * 
   * @return: A list of all Badgers living in the 
   * Sett in ascending order by size.
   * 
   */
  public java.util.List<Badger> getAllBadgers() {
    List<Badger> allBadgers = new ArrayList<Badger>();
    // initializes a list
    if (topBadger == null) {
      // checks if topBadger is null
      return allBadgers;
      // returns an empty list
    }
    getAllHelper(topBadger, allBadgers);
    // recurses through getAllHelper()
    return allBadgers;
    // returns the full list
  }

  /**
   * getAllHelper() is a recursive helper method is used 
   * to help collect the Badgers within this Sett into 
   * a List.
   * 
   * @param current - The current Badger that is the root 
   * of a (sub) tree that we are collecting all contained 
   * Badgers within, into the allBadgers List.
   * 
   * @param allBadgers - The list of all Badgers living in the Sett 
   * that is rooted at the current Badger node. The contents of this 
   * list should be in ascending order by Badger size.
   * 
   */
  private void getAllHelper(Badger current, 
      zjava.util.List<Badger> allBadgers) {
    if (current != null) {
      // checks if current is null
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers);
      // recurses left
      allBadgers.add(current);
      // adds node to the list
      getAllHelper(current.getRightLowerNeighbor(), allBadgers);
      // recurses right
    }
  }

  /**
   * getHeight() computes the height of the Sett, 
   * as the number of nodes from root to the 
   * deepest leaf Badger node.
   * 
   * @param: none
   * 
   * @return: The depth of this Sett.
   * 
   */
  public int getHeight() {
    if (topBadger == null) {
      // checking if the topBadger is null
      return 0;
      // returns 0
    }
    return getHeightHelper(topBadger);
    // recurses through all of the tree
  }

  /**
   * getHeightHelper() is a recursive helper method is 
   * used to help compute the height of this Sett.
   * 
   * @param current - The current Badger that is the 
   * root of a (sub) tree that we are calculating 
   * the height of.
   * 
   * @return: The height of the (sub) tree that we 
   * are calculating.
   * 
   */
  private int getHeightHelper(Badger current) {
    int heightL = 0;
    // sets left height to 0
    int heightR = 0;
    // sets right height to 0
    if (current == null) {
      // checks if current is null
      return 0;
      // returns 0
    } else {
      heightL++;
      // increments left height
      heightL += getHeightHelper(current.getLeftLowerNeighbor());
      // increments left height to left recursion
      heightR++;
      // increments right height
      heightR += getHeightHelper(current.getRightLowerNeighbor());
      // increments right height to right recursion
    }
    if (heightL > heightR) {
      // checks if the left height is greater 
      //than right height
      return heightL;
      // returns left height
    } else {
      return heightR;
      // returns right height
    }
  }

  /**
   * getLargestBadger() retrieves the largest Badger 
   * living in this Sett.
   * 
   * @param: none
   * 
   * @return: The largest Badger living in this Sett.
   * 
   */
  public Badger getLargestBadger() {
    if (topBadger == null) {
      // checks if the root node is null
      return topBadger;
      // returns root node
    }
    Badger current = topBadger;
    // sets current to topBadger
    while (current.getRightLowerNeighbor() != null) {
      // while the right neighbor is not null
      current = current.getRightLowerNeighbor();
      // sets current to the right neighbor
    }
    return current;
    // returns current
  }

  /**
   * getTopBadger() retrieve the top Badger within 
   * this Sett (the one that was settled first).
   *
   * @param: none
   *
   * @return: The Badger living on the top of 
   * the current Sett.
   * 
   */
  public Badger getTopBadger() {
    return topBadger;
    // returns topBadger
  }

  /**
   * isEmpty() checks whether this Sett is empty.
   * 
   * @param: none
   * 
   * @return: true if this Sett is empty, 
   * false otherwise.
   * 
   */
  public boolean isEmpty() {
    if (topBadger == null) {
      // checks if the topBadger is null
      return true;
      // returns true
    }
    return false;
    // returns false
  }

  /**
   * settleBadger() creates a new Badger object 
   * with the specified size, and inserts them 
   * into this Sett (BST). You must implement 
   * the naive insert algorithm  which only 
   * preserves the order property of each 
   * node, and is not guaranteed to result
   *  in balance.
   *  
   * @param size - The size of the new 
   * Badger that will be settled.
   * 
   * @throws java.lang.IllegalArgumentException - 
   * When a Badger with the specified size already
   *  exists within this Sett.
   * 
   */
  public void settleBadger(int size) 
      throws java.lang.IllegalArgumentException {
    if (topBadger == null) {
      // checks if topBadger is null
      topBadger = new Badger(size);
      // creates a topBadger
    } else {
      Badger b = new Badger(size);
      // creates a Badger
      settleHelper(topBadger, b);
      // calls settleHelper with topBadger
      // and the new Badger
    }
  }

  /**
   * settleHelper() This recursive helper method 
   * is used to help settle a new Badger within 
   * this Sett.
   * 
   * @param current - The current Badger 
   * (previously settled within this Sett) that 
   * we are considering settling the newBadger 
   * beneath (either to its left or right).
   * 
   * @param newBadger - The new Badger that
   * needs to be settled within this Sett.
   * 
   * @throws java.lang.IllegalArgumentException - When a 
   * Badger with the specified size already exists 
   * within this Sett.
   * 
   */
  private void settleHelper(Badger current, Badger newBadger)
      throws java.lang.IllegalArgumentException {
    if (current == null) {
      // checks if current is null
      current = newBadger;
      // sets current is newBadger
    } else {
      if (newBadger.getSize() < current.getSize()) {
        // checks if the newBadger size is less than current size
        if (current.getLeftLowerNeighbor() == null) {
          // checks if current's left neighbor is null
          current.setLeftLowerNeighbor(newBadger);
          // sets current's left neighbor to newBadger
        } else {
          settleHelper(current.getLeftLowerNeighbor(), newBadger);
          // recurses left
        }
      }
      if (newBadger.getSize() == current.getSize()) {
        // check if the newBadger's size is equal
        // to the current's size
        throw new IllegalArgumentException(
            "WARNING: failed to " 
        + "settle the badger with size " + newBadger.getSize()
                + ", as there is already a badger with the " 
        + "same size in this sett");
        // throws exception
      }
      if (newBadger.getSize() > current.getSize()) {
        // checks if the newBadger size is less than current size
        if (current.getRightLowerNeighbor() == null) {
          // checks if current's right neighbor is null
          current.setRightLowerNeighbor(newBadger);
          // sets current's right neighbor to newBadger
        } else {
          settleHelper(current.getRightLowerNeighbor(), newBadger);
          // recurses right
        }
      }
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
    
  }
}

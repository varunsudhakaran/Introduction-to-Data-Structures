//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Program7_SequenceGenerator
// Files: Sequence.java, ArithmeticSequenceGenerator.java, 
// GeometricSequenceGenerator. java, DigitProductSequenceGenerator.java
// SequenceGeneratorTests.java
// Course: CS 300, Semester 1, and Freshman
//
// Author: Varun Sudhakaran
// Email: vsudhakaran@wisc.edu
// Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;

/**
 * FibonacciSequenceGenerator implements Iterator<Integer>. This 
 * sequence works through an prev and next to get the next elements
 * 
 *@author varunsudhakaran
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  private int prev; // previous item in the sequence with 
  //respect to the current iteration
  private int next; // next item in the sequence 
  //with respect to the current iteration
  private int generatedCount; 
  // number of items generated so far


  // constructor
  /**
   * Constructor builds the fields into the variables
   * passed in as parameters
   * 
   * @param int size
   * 
   * @return: none
   * 
   */
  public FibonacciSequenceGenerator(int size) {
    // Your code comes here
    if (size < 0) { // if size is less than zero.
      throw new IllegalArgumentException
      ("WARNING: CANNOT create a sequence with size <= zero."); 
      // throws error
    }
    this.SIZE = size; // sets field to size
    this.prev = 0; // sets field to 0
    this.next = 1; // set field to 1
    this.generatedCount = 0; // generatedCount to 0
  }


  // Override hasNext() and next() methods
  @Override
  // TODO time complexity: O(1) constant
  /**
   * This method checks to see if there
   * is a next variable in the sequence
   * 
   * @param: none
   * 
   * @return: boolean that represents if there is a next 
   * 
   */
  public boolean hasNext() {
    
    // TODO Your code comes here
    return generatedCount < SIZE; // returns the result of 
    //this statement
  }

  @Override
  // TODO Your code comes here
// TODO time complexity: O(1) constant
  /**
   * This method gets the next element in the sequence
   * 
   * @param: none
   * 
   * @return: Integer that represents the next sequence element
   * 
   */
  public Integer next() {
    if (!hasNext()) { // hasNext equals null
      return null; // returns null
    }
    int temp = prev; // sets temp to prev
    generatedCount++; // increments generatedCount
    prev += next; // increments prev to next
    next = temp; // sets next to temp
    return next; // returns next
  }

  // You CAN add public accessor and mutator methods as needed 
  //here in order
  /**
   * main method that represents testing of methods
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

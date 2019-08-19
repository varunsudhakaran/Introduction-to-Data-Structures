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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * GeometricSequenceGenerator implements Iterator<Integer>. This 
 * sequence works through an initial number and a common ratio that is
 * used through the sequence
 * 
 * @author varunsudhakaran 
 *
 */

public class DigitProductSequenceGenerator {
  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; 
  // ArrayList object storing the sequence

  // constructor
  /**
   * Constructor builds the fields into the variables
   * passed in as parameters
   * 
   * @param int init
   * @param int size
   * 
   * @return: none
   * 
   */
  public DigitProductSequenceGenerator(int init, int size) {
    if (size <= 0) { // if size was less than or equal to zero
      throw new IllegalArgumentException
      ("WARNING: CANNOT create a sequence with size <= zero."); 
      // throws error
    }
    if (init <= 0) { // if init is less than or equal to zero
      throw new IllegalArgumentException(
          "WARNING: The starting element for digit"
          + " product sequence cannot be less than or equal to zero."); 
      // throws error 
    }
    this.INIT = init; // makes field equal to the parameter
    this.SIZE = size; // makes field equal to size
    this.sequence = new ArrayList<Integer>(); // initializes arraylist
    generateSequence(); // calls generateSequence method
  }

  /**
   * THe generateSequence() method makes the sequence
   * for the class
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public void generateSequence() {
    // TODO Generate the DigitProduct sequence using loop(s)
    for (int i = 0; i < sequence.size(); i++) { 
      // iterates through for loop
      sequence.remove(i); // removes all the indexes
    }
    int ctr = 0; // initializes ctr to zero.
    int current = INIT; // initializes current to INIT.
    sequence.add(INIT); // adds INIT to the sequence
    ctr++; // incremements ctr
    while (ctr < SIZE) { // runs until ctr >= SIZE
      int product = 1; //initializes product to 1
      String n =""; // makes empty String
      n+= current; // adds current to String
      String s = n.replaceAll("0", "");
      // replaces all 0's in String to empty
      for (int i = 0; i < s.length(); i++) { 
        // iterates through for loop
        int num = Character.getNumericValue(s.charAt(i)); 
        // convers char into integer
        product *= num; // gets product of the index
      }      
      current = current + product; // adds product to the 
      //previous index
      sequence.add(current); // adds current to sequence
      ctr++; // incermeents ctr
    }
  }  
  /**
   * The method serves as a way to iterate through 
   * your sequence with the iterator object you return
   * 
   * @param: none
   * 
   * @return: Iterator<Integer> object
   */
  public Iterator<Integer> getIterator() {
    // TODO return an Iterator to iterate over the ArrayList 
    //sequence field
    return sequence.iterator(); // returns an iterator
  }

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

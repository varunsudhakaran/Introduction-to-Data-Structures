
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

public class SequenceGeneratorTests {
  /**
   * Method tests GeometricSequenceGenerator
   * 
   * @param: none
   * 
   * @return boolean representing result of test
   */
  public static boolean geometricSequenceGeneratorTest() {
    try { // try block
      int initial = 2; //Initializes initial to 2
      int ratio = 2; // Initializes ratio to 2
      int size = 4; // Initializes size to 4 
      GeometricSequenceGenerator g = new 
          GeometricSequenceGenerator(initial, ratio, size);
      // creates new generator
      g.next(); // gets next
      g.next(); // gets next
      if (!g.hasNext() || g.next() != 8) { 
        // checks if hasNext is null or if next equals 4
        return false; // returns false
      }
    } catch (IllegalArgumentException e) { // catches error
      return false; // returns false
    }
    return true; // returns true
  }

  /**
   * Method tests FibonacciSequenceGenerator
   * 
   * @param: none
   * 
   * @return boolean representing result of test
   */
  
  public static boolean fibonacciSequenceGeneratorTest() {
    try { // try block
    int size = 4; // initializes size to 6
    FibonacciSequenceGenerator f = new 
        FibonacciSequenceGenerator(size); 
    // creates new generator
    f.next(); // gets next
    f.next(); // gets next
    f.next(); //  gets next
    f.next(); // gets next
    if(f.hasNext() || f.next() != null) { 
      // checks if hasNext is null or if next equals 2
      return false; // returns false
      }
    }
    catch(IllegalArgumentException e) { 
      // catches error
      return false; // return false
    }
    return true; // returns true
  }

  /**
   * Method tests DigitProductSequenceGenerator
   * 
   * @param: none
   * 
   * @return boolean representing result of test
   */
  
  public static boolean digitProductSequenceGenerator() {
    try { // try block
      int initial = 2; // initializes initial to 2
      int size = 4; // initializes size is 4
      DigitProductSequenceGenerator d = 
          new DigitProductSequenceGenerator(initial, size); 
      // creates new generator
    } catch (IllegalArgumentException e) { 
      // catches error
      return false; // returns false
    }
    return true; // returns true
  }

  /**
   * main method that represents testing of the test methods
   * 
   * @param args
   * 
   * @return: none
   * 
   */
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int fails = 0;
    if (!geometricSequenceGeneratorTest()) {
      System.out.println("geometricSequenceGeneratorTest fails");
      fails++;
    }
    if (!fibonacciSequenceGeneratorTest()) {
      System.out.println("fibonacciSequenceGeneratorTest fails");
      fails++;
    }
    if (!digitProductSequenceGenerator()) {
      System.out.println("digitProductSequenceGenerator fails");
      fails++;
    }
    if (fails == 0) {
      System.out.println("All tests pass!");
    }
  }
}



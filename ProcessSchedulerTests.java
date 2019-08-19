////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Program10_SJFProcessScheduler
//Files: CustomProcess.java, CustomProcessQueue.java, 
//       ProcessScheduler.java, ProcessSchedulerTests.java
//       WaitingQueueADT.java        
//Course: CS 300, Semester 1, and Freshman
//
//Author: Varun Sudhakaran
//Email: vsudhakaran@wisc.edu
//Lecturer's Name: Professor Gary Dahl
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class represents a ProcessSchedulerTests that is going
 * to test the enqueue and dequeue methods of CustomProcessQueue
 * 
 * @author varunsudhakaran 
 *
 */
public class ProcessSchedulerTests {
  /**
   * testEnqueueCustomProcessQueue() method tests
   * if the enqueue() method is implemented properly
   * 
   * @param: none
   * 
   * @return: true, if works, false, if fails
   * 
   */
  public static boolean testEnqueueCustomProcessQueue() {
    // checks the correctness of the enqueue
    // operation implemented in the CustomProcessQueue class
    CustomProcessQueue c = new CustomProcessQueue();
    // creates a new CustomProcessQueue
    CustomProcess c1 = new CustomProcess(5);
    // creates CustomProcess with id 5
    CustomProcess c2 = new CustomProcess(10);
    // creates CustomProcess with id 10
    CustomProcess c3 = new CustomProcess(15);
    // creates CustomProcess with id 15
    CustomProcess c4 = new CustomProcess(20);
    // creates CustomProcess with id 20
    CustomProcess c5 = new CustomProcess(25);
    // creates CustomProcess with id 25
    CustomProcess c6 = new CustomProcess(30);
    // creates CustomProcess with id 30
    CustomProcess c7 = new CustomProcess(2);
    // creates CustomProcess with id 2
    c.enqueue(c1);
    // enqueues c1
    c.enqueue(c2);
    // enqueues c2
    c.enqueue(c3);
    // enqueues c3
    c.enqueue(c4);
    // enqueues c4
    c.enqueue(c5);
    // enqueues c5
    c.enqueue(c6);
    // enqueues c6
    c.enqueue(c7);
    // enqueues c7
    if(c.peek().equals(c7)) {
      // checks if the peek() equals the c7
      return true;
      // returns true
    }
    else {
      return false;
      // returns false
    }
  }
  /**
   * testDequeueCustomProcessQueue() method tests
   * if the dequeue() method is implemented properly
   * 
   * @param: none
   * 
   * @return: true, if works, false, if fails
   * 
   */
  public static boolean testDequeueCustomProcessQueue() {
    // checks the correctness of the dequeue
    // operation implemented in the CustomProcessQueue class
    CustomProcessQueue c = new CustomProcessQueue();
    // creates a new CustomProcessQueue
    CustomProcess c1 = new CustomProcess(5);
    // creates CustomProcess with id 5
    CustomProcess c2 = new CustomProcess(10);
    // creates CustomProcess with id 10
    CustomProcess c3 = new CustomProcess(15);
    // creates CustomProcess with id 15
    CustomProcess c4 = new CustomProcess(20);
    // creates CustomProcess with id 20
    CustomProcess c5 = new CustomProcess(25);
    // creates CustomProcess with id 25
    CustomProcess c6 = new CustomProcess(30);
    // creates CustomProcess with id 30
    CustomProcess c7 = new CustomProcess(35);
    // creates CustomProcess with id 2
    c.enqueue(c1);
    // enqueues c1
    c.enqueue(c2);
    // enqueues c2
    c.enqueue(c3);
    // enqueues c3
    c.enqueue(c4);
    // enqueues c4
    c.enqueue(c5);
    // enqueues c5
    c.enqueue(c6);
    // enqueues c6
    c.enqueue(c7);
    // enqueues c7
    int i = 5;
    // sets i to 5
    while(!c.isEmpty()) {
      // checks if the CustomProcessQueue is not empty
      if(c.dequeue().getBurstTime() != i) {
        // checks if the burstTime is not equal to i
        return false;
        // returns false
      }
      i+=5;
      // increments i by 5
    }
    return true;
    // returns true
  }
  
  /**
   * testisEmpty() method tests
   * if the isEmpty() method is implemented properly
   * 
   * @param: none
   * 
   * @return: true, if works, false, if fails
   */
  public static boolean testisEmpty() {
    CustomProcessQueue c = new CustomProcessQueue();
    // creates a new CustomProcessQueue
    if(!c.isEmpty()){
      // checks if the CustomProcessQueue is not empty
      return false;
      // returns false
    }
    CustomProcess c1 = new CustomProcess(5);
    // creates CustomProcess with id 5
    c.enqueue(c1);
    // enqueues c1
    if(c.isEmpty()) {
      // checks if the CustomProcessQueue is empty
      return false;
      // returns false
    }
    return true;
  }
  
  /**
   * testPeek() method tests
   * if the peek() method is implemented properly
   * 
   * @param: none
   * 
   * @return: true, if works, false, if fails
   */
  public static boolean testPeek() {
    CustomProcessQueue c = new CustomProcessQueue();
    // creates a new CustomProcessQueue
    CustomProcess c1 = new CustomProcess(5);
    // creates CustomProcess with id 5
    CustomProcess c2 = new CustomProcess(10);
    // creates CustomProcess with id 10
    CustomProcess c3 = new CustomProcess(15);
    // creates CustomProcess with id 15
    CustomProcess c4 = new CustomProcess(2);
    // creates CustomProcess with id 2
    c.enqueue(c1);
    // enqueues c1
    c.enqueue(c2);
    // enqueues c2
    c.enqueue(c3);
    // enqueues c3
    c.enqueue(c4);
    // enqueues c4
    if(c.peek().equals(c4)) {
      // checks if peek equals c4
      return true;
      // returns true
    }
    else {
      return false;
      // returns false
    }
  }

  /**
   * main() method tests all of the test methods
   * 
   * @param args
   * 
   * @return: none
   * 
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int fails = 0;
    // sets fails to 0
    if(!testEnqueueCustomProcessQueue()) {
      // checks if method is false
      fails++;
      // increments fails
      System.out.println("testEnqueueCustomProcessQueue fails!");
      // prints message 
    }
    if(!testDequeueCustomProcessQueue()) {
      // checks if method is false
      fails++;
      // increments fails
      System.out.println("testDequeueCustomProcessQueue fails!");
      // prints message
    }
    if(!testisEmpty()) {
      // checks if method is false
      fails++;
      // increments fails
      System.out.println("testisEmpty fails!");
      // prints message
    }
    if(!testPeek()) {
      // checks if method is false
      fails++;
      // increments fails
      System.out.println("testPeek fails!");
      // prints message
    }
    if(fails == 0) {
      // checks if fails is 0
      System.out.println("All tests pass!");
      // prints message
    }
  }

}

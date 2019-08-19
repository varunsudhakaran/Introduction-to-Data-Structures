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
 * This interface will be implemented as a PriorityQueue
 * which the CustomProcessQueue implements in order
 * to use the methods by overriding them 
 * 
 * @author varunsudhakaran
 *
 * @param: <T>
 */
public interface WaitingQueueADT<T extends Comparable<T>> {
  
  /**
   * enqueue() method adds an element to heap
   * 
   * @param: newObject
   * 
   * @return: none 
   * 
   */
  public void enqueue(T newObject); 
  // inserts a newObject in the priority queue
  
  /**
   * dequeue() method removes the first element to heap
   * 
   * @param: none
   * 
   * @return: T
   * 
   */
  public T dequeue(); 
  // removes and returns the item with the highest priority
 
  /**
   * peek() method returns first element of heap
   * 
   * @param: none
   * 
   * @return: T
   * 
   */
  public T peek(); 
  // returns without removing the item with the highest priority
 
  /**
   * size() method returns the queue
   * 
   * @param: none
   * 
   * @return: size
   * 
   */
  public int size(); 
  // returns size of the waiting queue
 
  /**
   * isEmpty() method sees if the queue is empty
   * 
   * @param: none
   * 
   * @return: true, if empty, false, if full
   * 
   */
  public boolean isEmpty(); 
  // checks if the waiting queue is empty
}

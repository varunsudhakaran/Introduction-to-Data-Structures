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
 * This class represents a CustomProcess that will build
 * what a process should contain and how we compare them
 * 
 * @author varunsudhakaran 
 *
 */
public class CustomProcess implements Comparable<CustomProcess>{

private static int nextProcessId = 1; 
// stores the id to be assigned to the next process 
                                      
// to be created
private final int PROCESS_ID; 
// unique identifier for this process
private int burstTime; 
// time required by this process for CPU execution


/**
 * CustomProcess() constructor builds the
 * burstTime, the PROCESS_ID, and nextProcessId   
 *   
 * @param: int burstTime
 * 
 * @return: none
 */
public CustomProcess(int burstTime) { 
  this.burstTime = burstTime;
  // sets field to burstTime
  this.PROCESS_ID = nextProcessId;
  // sets field to nextProcessId
  nextProcessId++;
  // increments nextProcessId
}

/**
 * compareTo() method compares two
 * objects to test their priorities
 * 
 * @param: CustomProcess other
 * 
 * @return: integer
 */
public int compareTo(CustomProcess other) {
  if(other == null) {
    // if the object is null
    return -1;
    // returns -1
  }
  if(this.burstTime < other.getBurstTime()) {
    // checks if field burstTime is less than 
    //the other's burstTime
    return -1;
    // returns -1
  }
  else if(this.burstTime == other.getBurstTime()) {
    // checks if field burstTime is equal to 
    //other's burstTime
    if(this.getProcessId() < other.getProcessId()) {
      // checks if field processId is less than other's processId
      return -1;
      // returns -1
    }
    else if(this.getProcessId() > other.getProcessId()) {
      // checks if field processId is greater than other's processId
      return 1;
      // returns 1
    }
    else {
    return 0;
    // returns 0
    }
  }
  else {
    return 1;
    // returns 1
  }
}

/**
 * getProcessID() method gets the PROCESS_ID
 * 
 * @param: none
 * 
 * @return: PROCESS_ID
 * 
 */
public int getProcessId() {
  return this.PROCESS_ID;
  // returns PROCESS_ID
}
 
/**
 * getBurstTime() method gets the burstTime
 * 
 * @param: none
 * 
 * @return: burstTime
 * 
 */
public int getBurstTime() {
  return this.burstTime;
  // returns burstTime
}

/**
 * main() method is used for testing and to debug code
 * 
 * @param: args
 * 
 * @return: none
 * 
 */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

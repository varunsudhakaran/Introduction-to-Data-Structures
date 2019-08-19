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


import java.util.Scanner;

/**
 * This class represents a ProcessScheduler that runs 
 * through the Processes scheduled that is stored
 * in the heap
 * 
 * @author varunsudhakaran 
 *
 */
public class ProcessScheduler {

  private int currentTime; // stores the current time after 
  //the last run
  private int numProcessesRun; // stores the number of 
  //processes run so far
  private CustomProcessQueue queue; // this processing unit's 
  //custom process queue

  /**
   * ProcessScheduler() constructor builds the queue
   * as well as initializes the currentTime and the
   * numProcessesRun.
   */
  public ProcessScheduler() {
    this.queue = new CustomProcessQueue();
    // makes new queue
    this.currentTime = 0;
    // sets currentTime to 0
    this.numProcessesRun = 0;
    // sets numProcessesRun to 0
  }

  /**
   * scheduleProcess() method enqueues a process
   * onto the heap
   * 
   * @param: CustomProcess process
   * 
   * @return: none
   * 
   */
  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process);
    // enqueues process
  }

  /**
   * run() method adds onto a string that runs a series 
   * of commands when the job is running or when the job
   * is done.
   * 
   * @param: none
   * 
   * @return: String
   */
  public String run() {
    String s = "";
    // makes an empty string
    if (queue.size() == 0 || queue.size() == 1) {
      // checks if the size is 0 or 1
      s += "Starting " + queue.size() + " process\n\n";
      // adds this statement to the string
    } else {
      s += "Starting " + queue.size() + " processes\n\n";
      // adds this statement to the string
    }
    while (queue.size() > 0) {
      // runs while the queue size is greater than zero
      CustomProcess temp = queue.dequeue();
      // creates a temp and sets it to the dequeued process
      s += "Time " + currentTime + ": Process ID " 
      + temp.getProcessId() + " Starting.\n";
      // adds this statement to string
      currentTime += temp.getBurstTime();
      // adds each burstTime to the currentTime
      s += "Time " + currentTime + ": Process ID " 
      + temp.getProcessId() + " Completed.\n";
      // adds this statement to string
      numProcessesRun++;
      // increments numProcessesRun
    }
    s += "\nTime " + currentTime 
        + ": All scheduled processes completed.\n";
    // adds this statement to String
    return s;
    // returns string
  }
 
  /**
   * getCurrentTime() gets currentTime
   * 
   * @param: none
   * 
   * @return: currentTime
   * 
   */
  public int getCurrentTime() {
    return currentTime;
    // returns currentTime
  }
  
  /**
   * getNumProcesssesRun() gets numProcessesRun
   * 
   * @param: none
   * 
   * @return: numProcessesRun
   * 
   */
  public int getNumProcessesRun() {
    return numProcessesRun;
    // returns numProcessesRun
  }

  /**
   * main() method creates a user interface 
   * and is implemented as a driver
   * 
   * @param args
   * 
   * @return: none 
   * 
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ProcessScheduler p = new ProcessScheduler();
    // creates new ProcessScheduler
    Scanner scan = new Scanner(System.in);
    // makes scanner
    System.out.println("==========   Welcome to the S" 
    + "JF Process Scheduler App   ========\n\n");
    // prints message
    while (true) {
      // infinite while loop
      System.out.println("Enter command:\n" 
      + "[schedule <burstTime>] or [s <burstTime>]\n"
          + "[run] or [r]\n" + "[quit] or [q]");
      // prints message
      String s = scan.nextLine();
      // scans line
      String[] parts = s.split(" ");
      // splits string into parts by a space
      String command = parts[0];
      // sets command to first index of array
      if (parts.length == 2) {
        // checks if the parts' length is 2
        if (command.toLowerCase().equals("run") 
            || command.toLowerCase().equals("r")
            || command.toLowerCase().equals("quit") 
            || command.toLowerCase().equals("q")) {
          // checks if command is equal to run or r or quit or q
          System.out.println("WARNING: Please enter a valid command!\n");
          // prints message
        } else {
          if (!command.toLowerCase().equals("schedule") 
              && !command.toLowerCase().equals("s")) {
            // checks if command is equal to schedule or s
            System.out.println("WARNING: Please enter "
                + "a valid command!\n");
            // prints message
          } else {
            try {
              // try block
              int num = Integer.parseInt(parts[1]);
              // turns the second index of the string into an integer 
              if (num <= 0) {
                // checks if num is less than or equal to zero
                System.out.println("WARNING: burst time MUST "
                    + "be greater than 0!\n");
                // prints message
              }
              if (command.toLowerCase().equals("schedule")
                  || command.toLowerCase().equals("s") && num > 0) {
                // checks if the command is equal to schedule or zero and
                // num is greater than zero
                CustomProcess c = new CustomProcess(num);
                // creates new CustomProcess
                p.scheduleProcess(c);
                // schedules the process
                System.out.println(
                    "Process ID " + c.getProcessId() 
                    + " scheduled. Burst Time = " + num + "\n");
                // prints message
              }
            } catch (NumberFormatException e) {
              // catches the exception
              System.out.println("WARNING: burst time "
                  + "MUST be an integer!\n");
              // prints message
            }
          }
        }
      }
      if (parts.length == 1) {
        // checks if the parts' length is 1
        if (!command.toLowerCase().equals("run") 
            && !command.toLowerCase().equals("r")
            && !command.toLowerCase().equals("quit") 
            && !command.toLowerCase().equals("q")) {
          // checks if command is not equal to run or r or quit or q
          System.out.println("WARNING: Please enter a valid command!\n");
          // prints message
        } else {
          if (command.toLowerCase().equals("run") 
              || command.toLowerCase().equals("r")) {
            // checks if command is equal to run or r
            System.out.println(p.run());
            // prints the run method's string
          }
          if (command.toLowerCase().equals("quit") 
              || command.toLowerCase().equals("q")) {
            // checks if the command is equal to quit or q
            System.out.println(p.getNumProcessesRun() 
                + " processes run in " + p.getCurrentTime()
                + " units of time!\n" 
                + "Thank you for using our scheduler!\n" 
                + "Goodbye!\n");
            // prints message
            break;
            // breaks
          }
        }
      }
      if (parts.length > 2) {
        // checks if the parts length is greater than 2
        System.out.println("WARNING: Please enter a valid command!\n");
        // prints message
      }
    }
  }
}

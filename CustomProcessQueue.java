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
 * This class represents a CustomProcessQueue that is going to 
 * implement a PriorityQueue of CustomProcesses.
 * 
 * @author varunsudhakaran 
 *
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {

  private static final int INITIAL_CAPACITY = 20; 
  // the initial capacity of the heap
  private CustomProcess[] heap; 
  // array-based min heap storing the data. 
  //This is an oversize array
  private int size; 
  // number of CustomProcesses present 
  //in this CustomProcessQueue

  
  /**
   * CustomProcessQueue() constructor builds
   * the heap for the rest of the class
   * 
   * @param: none
   * 
   * @return: none
   * 
   */
  public CustomProcessQueue() {
    this.heap = new CustomProcess[INITIAL_CAPACITY];
    // sets the heap to an empty oversize array of
    // INITIAL_CAPACITY
  }



  @Override
  /**
   * enqueue() method adds the CustomProcess
   * to the heap array and uses the minHeapPercolateUp
   * to sort through
   * 
   * @param: CustomProcess newObject
   * 
   * @return: none
   * 
   */
  public void enqueue(CustomProcess newObject) {
    // TODO Auto-generated method stub
    if (size == 0) {
      // checks if the size is zero
      heap[1] = newObject;
      // sets the first index as newObject
      size++;
      // increments size
    } else {
      heap[size + 1] = newObject;
      // sets the last index as the newObject
      size++;
      // increments size
      minHeapPercolateUp(size);
      // recurses through minHeapPercolateUp
    }
  }


  @Override
  /**
   * dequeue() method removes the CustomProcess
   * at the top of the heap array 
   * and uses the minHeapPercolateDown to sort through
   * 
   * @param: none
   * 
   * @return: CustomProcess 
   * 
   */
  public CustomProcess dequeue() {
    // TODO Auto-generated method stub
    if (size == 0) {
      // checks if size is 0
      return null;
      // returns null
    } else {
      CustomProcess temp = heap[1];
      // sets temp to heap[1]
      heap[1] = heap[size];
      // sets heap[1] to last element
      heap[size] = null;
      // changes the last element to null
      size--;
      // decrements size
      minHeapPercolateDown(1);
      // minHeapPercolateDown of first index
      return temp;
      // returns the temp variable
    }
  }


  @Override
  /**
   * peek() method looks at the first index
   * of the heap array
   * 
   * @param: none
   * 
   * @return: CustomProcess
   * 
   */
  public CustomProcess peek() {
    // TODO Auto-generated method stub
    if (size == 0) {
      // checks if size is zero
      return null;
      // returns null
    } else {
      return heap[1];
      // returns first index
    }
  }


  @Override
  /**
   * size() method gets the size
   * 
   * @param: none
   * 
   * @return: size
   * 
   */
  public int size() {
    // TODO Auto-generated method stub
    return size;
    // returns size
  }


  @Override
  /**
   * isEmpty() checks if the heap is empty
   * 
   * @param: none
   * 
   * @return: true, if empty, false, if not
   * 
   */
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    if (size == 0) {
      // checks if size is zero
      return true;
      // returns true
    } else {
      return false;
      // returns false
    }
  }

  /**
   * minHeapPercolateUp() method goes sorts up
   * through a heap when an element is enqueued
   * 
   * @param: index
   * 
   * @return: none
   * 
   */
  private void minHeapPercolateUp(int index) {
    CustomProcess parentTemp;
    // makes CustomProcess parentTemp
    if (index != 0 && index != 1) {
      // checks if index is not equal to 0
      // checks if index is not equal to 1
      parentTemp = heap[index / 2];
      // sets parentTemp to heap[index/2]
      if (heap[index / 2].compareTo(heap[index]) > 0) {
        // compares if parent has less priority
        heap[index / 2] = heap[index];
        // swaps both of the nodes
        heap[index] = parentTemp;
        // swaps both of the nodes
        minHeapPercolateUp(index / 2);
        // recurses with index/2
      }
      if (heap[index].compareTo(heap[index / 2]) > 0) {
        // checks if parent has more priority
      }
    }
  }
  /**
   * minHeapPercolateDowm() method goes sorts down
   * through a heap when an element is dequeued
   * 
   * @param: index
   * 
   * @return: none
   * 
   */
  private void minHeapPercolateDown(int index) {
    CustomProcess temp;
    // sets temp variable
    if(index ==0 || 2*index > heap.length) {}
    // checks if index is zero
    // checks if the child is greater than the heap length
    else if(heap[2*index] == null) {}
    // checks if the child is null
    else {
      if(heap[2*index].compareTo(heap[2*index+1]) < 0) {
        // checks if left child has more priority than right child
        if(heap[index].compareTo(heap[2*index]) > 0) {
          // checks if parent has less priority than left child
          temp = heap[2*index];
          // sets temp to left child
          heap[2*index] = heap[index];
          // swaps both of them
          heap[index] = temp;
          // swaps both of them
          minHeapPercolateDown(index*2);
          // recurses down left child
        }
      }
      else if(heap[index].compareTo(heap[2*index+1]) > 0)
        // checks if the parent has less priority than right child
      { 
        temp = heap[2*index+1];
        // sets temp to the right child
        heap[2*index+1] = heap[index];
        // swaps both of them
        heap[index] = temp;
        // swaps both of them
        minHeapPercolateDown(index*2+1);
        // recurses down right child
      }
    }
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

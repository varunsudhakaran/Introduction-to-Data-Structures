import java.util.Arrays;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Program1_AuditableBanking
// Files: AuditableBanking.java, AuditbaleBanking
// Course: CS 300, Semester 1, and Freshman
//
// Author: Varun Sudhakaran
// Email: vsudhakaran@wisc.edu
// Lecturer's Name: Professor Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Steve Hizmi
// Partner Email: shizmi@wisc.edu
// Partner Lecturer's Name: Professor Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: Steve Hizmi helped me with the calculateCurrentBalance() method
// and calculateNumberOfOverdrafts().
// Online Sources: none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * The main method tests submitTransactions(), processCommandTest1(), processCommandTest2(),
 * testCalculateCurrentBalance(), and testNumberOfOverdrafts().
 * 
 * @param none
 * 
 * @return none
 */

public class AuditableBankingTests {

  public static void main(String[] args) {
    System.out.println("" + testProcessCommand1());
    System.out.println("" + testProcessCommand2());
    System.out.println("" + testCalculateCurrentBalance());
    System.out.println("" + testCalculateNumberOfOverdrafts());
  }

  /**
   * Makes sure that the command string works through the numbers of 0, 1, 2. This program accepts
   * the command as it is acceptable. The processCommand() also converts the arrays of string into a
   * into a character-base of strings. Additionally, the program converts the single strings into an
   * array of integers.
   * 
   * @param none
   * 
   * @param none
   * 
   * @param none
   * 
   * @return boolean variable that tests if the program works if the command String is starting with
   *         an accepted transactions number.
   */

  public static boolean testProcessCommand1() {
    // TODO: Implement this method
    int[][] allTransactions1 = new int[20][40];
    int allTransactionsCount1 = 0;
    String command1 = "1 0 1 1 0 1 1";
    if (AuditableBanking.processCommand(command1, allTransactions1, allTransactionsCount1) == 1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Makes sure that the command string works through the numbers of 0, 1, 2. This program denies
   * the command as it is unacceptable. The processCommand() also converts the arrays of string into
   * a into a character-base of strings. Additionally, the program converts the single strings into
   * an array of integers.
   * 
   * @param: none
   * 
   * @return boolean variable that tests if the program fails if the command String doesn't start
   *         with the intended transactions
   */

  public static boolean testProcessCommand2() {
    int[][] allTransactions2 = new int[20][40];
    int allTransactionsCount2 = 0;
    String command2 = "3 0 1 1 0 1 1";
    if (AuditableBanking.processCommand(command2, allTransactions2, allTransactionsCount2) == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Makes sure that the transactions that are input into the shell and the program will print out
   * the current balance. The program has a self-made allTransactions array that will be calculated
   * in order for the method to increment or decrement the balance accordingly.
   * 
   * @param none
   * 
   * @param none
   * 
   * @param none
   * 
   * @return boolean variable that tests if the program performs the correct current balance.
   */

  public static boolean testCalculateCurrentBalance() {
    // TODO: Implement this method
    int[][] allTransactions3 = new int[][] {{1, 10, -20, +30, -20, -20}, // +2 overdrafts (ending
                                                                         // balance: -20)
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // +2 overdrafts (ending balance: -15)
        {1, 115}, // +0 overdrafts (ending balance: +100)// +2 overdrafts (ending balance: -15)
    };;
    int allTransactionsCount3 = 3;
    // System.out.println(AuditableBanking.calculateCurrentBalance(allTransactions3,
    // allTransactionsCount3));
    if (AuditableBanking.calculateCurrentBalance(allTransactions3, allTransactionsCount3) == 100) {
      return true;
    }
    return false;
  }

  /**
   * Makes sure that the transactions that are input into the shell and the program will print out
   * the number of overdrafts. The program will conduct two tests that will check if the program
   * prints out the correct number of overdrafts for one transactions and for the fourth
   * transaction.
   * 
   * @param none
   * 
   * @param none
   * 
   * @param none
   * 
   * @return boolean variable that tests if the program performs the correct number of overdrafts.
   */

  public static boolean testCalculateNumberOfOverdrafts() {
    boolean foundProblem = false;
    int[][] transactions = new int[][] {{1, 10, -20, +30, -20, -20}, // +2 overdrafts (ending
                                                                     // balance: -20)
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // +2 overdrafts (ending balance: -15)
        {1, 115}, // +0 overdrafts (ending balance: +100)
        {2, 3, 1, 0, 1}, // +1 overdrafts (ending balance: -100)
    };

    // test with a single transaction of the Integer Amount encoding
    int transactionCount = 1;
    int overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
    if (overdrafts != 2) {
      System.out.println(
          "FAILURE: calculateNumberOfOverdrafts did not return 2 when transactionCount = 1, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TEST 1/2 of TestCalculateNumberOfOverdrafts!!!");

    // test with four transactions: including one of each encoding
    transactionCount = 4;
    overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
    if (overdrafts != 5) {
      System.out.println(
          "FAILURE: calculateNumberOfOverdrafts did not return 5 when transactionCount = 4, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TESTS 2/2 of TestCalculateNumberOfOverdrafts!!!");

    return !foundProblem;
  }

}

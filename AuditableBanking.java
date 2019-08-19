import java.util.Scanner;

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
 * Makes the Auditable Banking App functional and provides the user instructions to make the
 * transaction user friendly. The program tests the submitTransactions(), processCommand(),
 * calculateCurrrentBalance(), and calculateNumberOfOverdrafts() methods. The program guides you
 * through the program for additional transactions, to print out the current balancce, to print out
 * the number of overdrafts, or to quit the app.
 * 
 * @param none
 * 
 * @param none
 * 
 * @param none
 * 
 * @return none
 */

public class AuditableBanking {
  public static void main(String[] args) {
    // System.out.println("" + AuditableBankingTests.testProcessCommand1());
    // System.out.println("" + AuditableBankingTests.testProcessCommand2());
    // System.out.println("" + AuditableBankingTests.testCalculateCurrentBalance());
    // System.out.println("" + AuditableBankingTests.testCalculateNumberOfOverdrafts());
    final int ROW_CAP = 100;
    final int COL_CAP = 100;
    int[][] allTransactions = new int[ROW_CAP][COL_CAP];
    int allTransactionCounts = 0;
    // System.out.println(AuditableBankingTests.testProcessCommand1());
    // System.out.println(AuditableBankingTests.testProcessCommand2());
    // System.out.println(AuditableBankingTests.testCalculateCurrentBalance());
    Scanner scan = new Scanner(System.in);
    for (int i = 0; i < 10; i++) {
      System.out.print("=");
    }
    System.out.print(" Welcome to the Auditable Banking App ");
    for (int i = 0; i < 10; i++) {
      System.out.print("=");
    }
    int c = 1;
    while (c == 1) {
      System.out.println();
      System.out.println("\nCOMMAND MENU: ");
      System.out
          .println("  \nSubmit a Transaction (enter a sequence of integers seperated by spaces)");
      System.out.println("  \nShow a Current [B]alance");
      System.out.println("  \nShow a Number of [O]verdrafts");
      System.out.println("  \n[Q]uit Program");
      System.out.print("\nENTER COMMAND: ");
      String i = scan.nextLine();
      if (i.charAt(0) == 'q') {
        System.out.println("\n============ Thank you for using this App!!!! ============");
        c = 0;
        break;
      }
      allTransactionCounts = processCommand(i, allTransactions, allTransactionCounts);

    }
  }
  // extra comment
  // TODO Auto-generated method stub

  /**
   * Adds a transaction group to an array of transaction groFups. If the allTransactions array is
   * already full then this method will do nothing other than return allTransactionCount.
   * 
   * @param newTransactions      is the new transaction group being added (perfect size).
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *                             newTransactions is added.
   * @return the number of transaction groups within allTransactions after newTransactions is added.
   */
  public static int submitTransactions(int[] newTransactions, int[][] allTransactions,
      int allTransactionsCount) {

    allTransactions[allTransactionsCount] = newTransactions;

    allTransactionsCount++;
    return allTransactionsCount;
  }

  /**
   * Adds a transaction group to an array of transaction groups. If the allTransactions array is
   * already full then this method will do nothing other than return allTransactionCount. The method
   * splits the command String into smaller strings and turns them into integers. Then the program
   * increments allTransactionsCount based off of the credentials for a transactions
   * 
   * @param command              the String that gets input into the shell
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions before
   *                             newTransactions is added.
   * @return the updated number of transaction groups within allTransactions after newTransactions
   *         is added and as you input more Transactions.
   */

  public static int processCommand(String command, int[][] allTransactions,
      int allTransactionsCount) {
    // TODO: Implement this method
    if (command.charAt(0) == 'o' || command.charAt(0) == 'B' || command.charAt(0) == 'q') {
      // System.out.println("Test1");
      if (command.charAt(0) == 'B') {
        System.out.println(
            "Current Balance: " + calculateCurrentBalance(allTransactions, allTransactionsCount));
        return allTransactionsCount;
      }
      if (command.charAt(0) == 'o') {
        System.out.println("Number of Overdrafts: "
            + calculateNumberOfOverdrafts(allTransactions, allTransactionsCount));
        return allTransactionsCount;
      }
    }
    String[] commandArray = command.split(" ");
    int[] newTransaction = new int[commandArray.length];
    for (int i = 0; i < commandArray.length; i++) {
      newTransaction[i] = Integer.parseInt(commandArray[i]);
    }
    if (newTransaction[0] == 0 || newTransaction[0] == 1 || newTransaction[0] == 2) {
      // System.out.println("Test2");

      return allTransactionsCount =
          submitTransactions(newTransaction, allTransactions, allTransactionsCount);

    } else {
      // System.out.println("Test3");
      return allTransactionsCount;
    }
  }

  /**
   * Runs through allTransactions to calculate balance. The balance checks if the first index of the
   * transaction is 0, then it proceeds to calculate by increments and decrements of 1. The balance
   * checks if the first index is 1, then it proceeds to just accumulate all of the integers.
   * Finally, the program checks if the first index is 3, then proceeds to see if the second, third,
   * and fourth indexes to be a multiple of 20, 40, 80, 100. Ultimately, program calculates the
   * balance of the transactions.
   * 
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (after
   *                             newTransactions is added.
   * @return the balance that is resulted after the Transaction.
   */



  public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {
    // TODO: Implement this method
    int i;
    int j;
    int balance = 0;
    for (i = 0; i < allTransactionsCount; i++) {
      if (allTransactions[i][0] == 0) {
        for (j = 1; j < allTransactions[i].length; j++) {

          if (allTransactions[i][j] == 0) {
            balance--;
          }
          if (allTransactions[i][j] == 1) {
            balance++;
          }
        }
      }
      if (allTransactions[i][0] == 1) {
        // if(allTransactions[i][j] < 0)
        // {
        // balance -= allTransactions[i][j];
        // }
        // if(allTransactions[i][j] > 0)
        // {
        for (j = 1; j < allTransactions[i].length; j++) {

          balance += allTransactions[i][j];
        }
        // }

      }

      if (allTransactions[i][0] == 2) {
        for (j = 1; j < allTransactions[i].length; j++) {
          if (j == 1) {
            balance -= allTransactions[i][j] * 20;
          }
          if (j == 2) {
            balance -= allTransactions[i][j] * 40;
          }
          if (j == 3) {
            balance -= allTransactions[i][j] * 80;
          }
          if (j == 4) {
            balance -= allTransactions[i][j] * 100;
          }
        }
      }
    }
    return balance;

  }

  /**
   * Runs through allTransactions to count the number of overdrafts. The program runs through the
   * transaction to see if the balance is below zero. If the balance is below zero then the program
   * proceeds to increment the number of overdrafts to the number of times per transaction that the
   * balance will be below zero.
   * 
   * @param allTransactions      is the collection that newTransactions is being added to
   *                             (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (after
   *                             newTransactions is added.
   * @return the number of overdrafts that is resulted after the Transaction.
   */

  public static int calculateNumberOfOverdrafts(int[][] allTransactions, int allTransactionsCount) {
    // TODO: Implement this method
    int overdrafts = 0;
    int ctr = 0;
    int i;
    int j;
    int balance = 0;
    for (i = 0; i < allTransactionsCount; i++) {
      if (allTransactions[i][0] == 0) {
        for (j = 1; j < allTransactions[i].length; j++) {

          if (allTransactions[i][j] == 0) {
            balance--;
            if (balance < 0) {
              overdrafts++;
            }
          }
          if (allTransactions[i][j] == 1) {
            balance++;
          }
        }
      }
      if (allTransactions[i][0] == 1) {
        // if(allTransactions[i][j] < 0)
        // {
        // balance -= allTransactions[i][j];
        // }
        // if(allTransactions[i][j] > 0)
        // {
        for (j = 1; j < allTransactions[i].length; j++) {

          balance += allTransactions[i][j];
          if (balance < 0 && allTransactions[i][j] < 0) {
            overdrafts++;
          }
        }
        // }

      }

      if (allTransactions[i][0] == 2) {
        for (j = 1; j < allTransactions[i].length; j++) {
          if (j == 1) {
            balance -= allTransactions[i][j] * 20;
            if (balance < 20) {
              ctr = allTransactions[i][j];
            }
            for (int k = 0; k < allTransactions[i][j]; k++) {
              balance -= 20;
              if (balance < 0) {
                overdrafts++;
              }
            }
          }
        
        if (j == 2) {
          balance -= allTransactions[i][j] * 40;
          for (int g = 0; g < allTransactions[i][j]; g++) {
            balance -= 40;
            if (balance < 0) {
              overdrafts++;
            }
          }
        }
        if (j == 3) {
          balance -= allTransactions[i][j] * 80;
          for (int h = 0; h < allTransactions[i][j]; h++) {
            balance -= 80;
            if (balance < 0) {
              overdrafts++;
            }
          }
        }
        if (j == 4) {
          balance -= allTransactions[i][j] * 100;
          for (int k = 0; k < allTransactions[i][j]; k++) {
            balance -= 100;
            if (balance < 0) {
              overdrafts++;
            }
          }
        }
        }
      }
    }
    return overdrafts;
  }

}

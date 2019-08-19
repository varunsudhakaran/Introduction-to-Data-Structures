import java.util.*;



//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Program3_AccessControl
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
// Persons: Steve Hizmi helped me with the addUser() method
// Online Sources: none
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


public class AccessControlTest {

  /*
   * Testing main. Runs each test and prints which (if any) failed.
   */

  /*
   * main method() tests the tester methods to see if they are returning any failures or if they're
   * succeeding. If they all succeed, then the method prints out a success message.
   * 
   * @param: none
   * 
   * @return: none
   * 
   * 
   */

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int fails = 0;
    // tests testLogin1
    if (!testLogin1()) {
      System.out.println("testLogin1 [bad username] failed");
      fails++;
    }
    // tests testLogin2
    if (!testLogin2()) {
      System.out.println("testLogin2 [good login] failed");
      fails++;
    }
    // tests testLogin3
    if (!testLogin3()) {
      System.out.println("testLogin1 [bad username with default password] " + "failed");
      fails++;
    }
    // tests testAddUser1
    if (!testAddUser1()) {
      System.out.println("testAddUser1 [bad user] login failed");
      fails++;
    }
    // tests testAddUser2
    if (!testAddUser2()) {
      System.out.println("testAddUser2 [bad user] login failed");
      fails++;
    }
    // tests testRemoveUser1
    if (!testRemoveUser1()) {
      System.out.println("testRemoveUser1 [bad user] removing user failed");
      fails++;
    }
    // tests testGiveAdmin
    if (!testTakeAdmin()) {
      System.out.println("testTakeAdmin [bad user] takeAdmin failed");
      fails++;
    }
    // tests testTakeAdmin
    if (!testTakeAdmin()) {
      System.out.println("testTakeAdmin [bad user] takeAdmin failed");
      fails++;
    }
    if (fails == 0)
      System.out.println("All tests passed!");
  }

  /*
   * This test tries to log in a user that doesn't exist or does exist
   * 
   * @param: none
   * 
   * @return boolean variable that represents if the login is valid or not.
   */
  public static boolean testLogin1() {
    AccessControl ac1 = new AccessControl();
    String user = "probablyNotInTheSystem1234"; // not in system
    String pw = "changeme"; // DEFAULT_PASSWORD
    return !AccessControl.isValidLogin(user, pw);
    // isValidLogin should return false since login is invalid
  }

  public static boolean testLogin2() {
    AccessControl ac1 = new AccessControl();
    String user = "admin"; // in system
    String pw = "root"; // in system
    return AccessControl.isValidLogin(user, pw);
    // isValidLogin should return true since login is valid
  }

  public static boolean testLogin3() {
    AccessControl ac1 = new AccessControl();
    String user = "probablyNotInTheSystem12"; // not in system
    String pw = "root"; // in system
    return !AccessControl.isValidLogin(user, pw);
    // isValidLogin should return false since login is invalid
  }

  /*
   * testAddUser1() method creates a new AccessControl and do not log in an admin. Verify that
   * addUser(String username) returns false and that the new user is added.
   * 
   * @param: none
   * 
   * @return boolean variable that represents if the user is added.
   */
  public static boolean testAddUser1() {
    AccessControl ac1 = new AccessControl();
    String user = "Michael";
    boolean addUserReport = ac1.addUser(user); // calls addUser
    if (addUserReport)
      return false; // addUserReport should be false
    // Make sure user wasn't added anyway
    return !AccessControl.isValidLogin(user, "changeme");
  }

  /*
   * testAddUser2() method creates a new AccessControl and do not log in an admin. Verify that
   * addUser(String username) returns false and that the new user is added.
   * 
   * @param: none
   * 
   * @return: boolean to see if the user is added or not
   */

  public static boolean testAddUser2() {
    AccessControl ac2 = new AccessControl();
    String username = "shaquille";
    boolean addUserReport = ac2.addUser(username); // calls addUser
    if (addUserReport) {
      return false;
    }
    return !ac2.addUser(username);
  }

  /*
   * testRemoveUser2() method creates a new AccessControl and do not log in an admin. Verify that
   * addUser(String username) returns false and that the new user is removed.
   * 
   * @param: none
   * 
   * @return: boolean to see if the user is removed or not
   */

  public static boolean testRemoveUser1() {
    AccessControl ac2 = new AccessControl();
    String username = "jimmy";
    boolean addUserReport = ac2.removeUser(username); // calls removeUser
    if (addUserReport) {
      return false;
    }
    return !ac2.removeUser(username);
  }

  /*
   * testGiveAdmin() method checks to see if the currentUser is a null or if the currentUser is an
   * admin, based off of this, the method will set the isAdmin to false.
   * 
   * @param: none
   * 
   * @return boolean to see if the admin is given
   */

  public static boolean testGiveAdmin() {
    AccessControl ac1 = new AccessControl();
    String username1 = "kane";
    boolean takeAdminReport = ac1.giveAdmin(username1);// calls giveAdmin
    if (takeAdminReport) {
      return false;
    }
    return !ac1.giveAdmin(username1);
  }

  /*
   * testTakeAdmin() method checks to see if the currentUser is a null or if the currentUser is an
   * admin, based off of this, the method will set the isAdmin to false.
   * 
   * @param: none
   * 
   * @return boolean to see if the admin is taken away
   */

  public static boolean testTakeAdmin() {
    AccessControl ac1 = new AccessControl();
    String username1 = "james";
    boolean takeAdminReport = ac1.takeAdmin(username1); // calls takeAdmin
    if (takeAdminReport) {
      return false;
    }
    return !ac1.takeAdmin(username1);
  }


}

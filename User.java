
public class User {

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

  private final String username; // The user's name
  private String password; // The user's password
  private boolean isAdmin; // Whether or not the user has Admin powers

  /*
   * User Constructor takes in a username, password, and an isAdmin. The private field variables
   * will be set equal to the variables passed into the contructor.
   * 
   * @param: String username, String password, boolean isAdmin
   * 
   * @return: none
   * 
   * 
   */

  public User(String username, String password, boolean isAdmin) {
    // Creates a new user with the given password and admin status
    this.username = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  /*
   * IsValidLogin method takes in a password. The method checks if the password inputted in is equal
   * to the actual password. If so, returns true. If not, return false.
   * 
   * @param: String password
   * 
   * @return: boolean representing if the password was right or not
   * 
   * 
   */

  public boolean isValidLogin(String password) {
    // Report whether the password is correct
    // checks if the field password equals input password
    if (this.password.equals(password)) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * getUsername() method returns the username of the login
   * 
   * @param: none
   * 
   * @return: String representing the username
   * 
   * 
   */

  public String getUsername() {
    // Return the user's name
    return this.username; // returns the field username
  }

  /*
   * getIsAdmin() method returns whether the user is an admin or not.
   * 
   * @param: none
   * 
   * @return: boolean representing if the user is an admin or not.
   * 
   * 
   */

  public boolean getIsAdmin() {
    // Report whether the user is an admin
    // returns the field isAdmin
    return isAdmin;
  }

  /*
   * setPassword() takes in a password and sets the password of the login to the new password that
   * you input into the method.
   * 
   * @param: String password
   * 
   * @return: none
   * 
   * 
   */

  public void setPassword(String password) {
    // Set the new password
    // sets the field password to input password
    this.password = password;
  }

  /*
   * setIsAdmin() method sets the isAdmin status to what you input into the method
   * 
   * @param: boolean isAdmin
   * 
   * @return: none
   * 
   * 
   */

  public void setIsAdmin(boolean isAdmin) {
    // Set the new admin status
    // sets the field isAdmin to input isAdmin
    this.isAdmin = isAdmin;
  }

  /*
   * main() method being used to see if the toString() method runs properly
   * 
   * @param: none
   * 
   * @return: none
   * 
   * 
   */

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // creates User u1
    User u1 = new User("Roger", "Federer", true);
    // prints out the toString()
    System.out.println(u1.toString());

  }

  /*
   * toString() method returns a user in the form of it's specific login credentials. Print
   * statement is located in the main().
   * 
   * @param: none
   * 
   * @return: String
   * 
   * 
   */

  public String toString() {
    // returns the three strings as User object parameters
    return "" + username + password + isAdmin;
  }

}

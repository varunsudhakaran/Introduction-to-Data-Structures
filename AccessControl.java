import java.util.ArrayList;
import java.util.Scanner;
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

public class AccessControl {

  private static ArrayList<User> users; // An ArrayList of valid users
  private User currentUser; // Who is currently logged in, if anyone?
  private static final String DEFAULT_PASSWORD = "changeme"; // Default
  // password
  // given to new user
  // or when we reset a user's password.

  /*
   * AccessControl Constructor initializes the users ArrayList Creates a new User that is
   * administrating is the first user sets the currentUser to null
   * 
   * @param: none
   * 
   * @return: none
   * 
   * 
   */

  public AccessControl() {
    // A no-parameter constructor

    // initializes users arraylist
    users = new ArrayList<User>();
    // creates a new user
    User u = new User("admin", "root", true);
    // adds u to arraylist users
    users.add(u);
    // sets currentUser to null
    currentUser = null;
  }

  // main() {} // A STATIC method that creates a new AccessControl
  // object
  // An implementation for this method is provided below

  /*
   * isValidLogin() is a method that takes in a username and a password and makes sure that the
   * login is valid if the username is unique and isn't repetitive
   * 
   * @param: String username, String password
   * 
   * @return: boolean variable indicating if login is valid or not
   * 
   * 
   */

  public static boolean isValidLogin(String username, String password) {
    // Report whether a
    // given username/password pair is a valid login
    for (int i = 0; i < users.size(); i++) {
      // checks if the any of the index in users equals username
      if (users.get(i).getUsername().equals(username) && users.get(i).isValidLogin(password)) {
        return true;
      }
    }
    return false;
  }

  /*
   * changePassword is a method that takes in a newPassword that you input and changes your current
   * password to this new password. The method uses the setPassword method from user which acts as a
   * setter for this change.
   * 
   * @param: String newPassword
   * 
   * @return: none
   * 
   * 
   */

  public void changePassword(String newPassword) {
    // sets the password to newPassword
    currentUser.setPassword(newPassword);
  }

  /*
   * logout() is a method that disables your function to use the user interface and you won't be in
   * the user system or list.
   * 
   * @param: none
   * 
   * @return: none
   * 
   * 
   */

  public void logout() {
    // Log out the current user
    currentUser = null;
  }

  /*
   * setCurrentUser is a method that takes in the username and traces through arraylist of users to
   * find the username that matches your input. Once found, the method will set the username of the
   * index to currentUser.
   * 
   * @param: String username
   * 
   * @return: none
   * 
   * 
   */

  public void setCurrentUser(String username) {
    for (int i = 0; i < users.size(); i++) {
      // checks if the any of the index in users equals username
      if (users.get(i).getUsername().equals(username)) {
        currentUser = users.get(i);
      }
    }
  }

  // Administrators ONLY

  /*
   * addUser() method takes in a username and checks to see if currentUser is in the system.
   * Additionally, the method checks to see if the currentUser is an admin and if not, then they
   * cannot use the function of addUser. If they are an admin, then the method checks to see if the
   * username provided is already existing in the users arraylist. If not, then the method adds the
   * user.
   * 
   * @param: String username
   * 
   * @return: boolean representing if the method added user or not
   * 
   * 
   */

  public boolean addUser(String username) {
    // Create a new user (non-admin)
    // checks to see if currentUser is a null
    if (currentUser == null) {
      return false;
      // checks to see if currentUser is an admin
    } else if (currentUser.getIsAdmin() == true) {
      for (int i = 0; i < users.size(); i++) {
        // checks if the any of the index in users equals username
        if ((users.get(i).getUsername().equals(username))) {
          return false;
        }
      }
      // creates a user
      User u1 = new User(username, DEFAULT_PASSWORD, false);
      // adds the user
      users.add(u1);
      return true;
    } else {
      return false;
    }

  }

  /*
   * addUser() method takes in a username and isAdmin boolean. T he method checks to see if
   * currentUser is in the system. Additionally, the method checks to see if the currentUser is an
   * admin and if not, then they cannot use the function of addUser. If they are an admin, then the
   * method checks to see if the username provided is already existing in the users arraylist. If
   * not, then the method adds the user.
   * 
   * @param: String username, boolean isAdmin
   * 
   * @return: boolean variable representing if the method added user or not
   * 
   * 
   */

  public boolean addUser(String username, boolean isAdmin) {
    // Create a new user
    // and specify their admin status
    // checks to see if currentUser is an admin
    if (currentUser.getIsAdmin() == true) {
      for (int i = 0; i < users.size(); i++) {
        // checks if the any of the index in users equals username
        if (users.get(i).getUsername().equals(username)) {
          return false;
        }
      }
      // creates a user
      User u2 = new User(username, DEFAULT_PASSWORD, isAdmin);
      // adds the user
      users.add(u2);
      return true;
    } else {
      return false;
    }
  }

  /*
   * removeUser() method takes in a username. Additionally, the method checks to see if the
   * currentUser is an admin and if not, then they cannot use the function of removeUser. If they
   * are an admin, then the method checks to see if the username provided is already existing in the
   * users arraylist. If so, then the method removes the user.
   * 
   * @param: String username
   * 
   * @return: boolean representing if the program removed user or not
   * 
   * 
   */

  public boolean removeUser(String username) {
    // Remove a user (names should be unique)
    // checks to see if currentUser is null
    if (currentUser == null) {
      return false;
    }
    // checks to see if currentUser is an admin
    if (currentUser.getIsAdmin() == true) {
      for (int i = 0; i < users.size(); i++) {
        // checks if the any of the index in users equals username
        if (username.equals(users.get(i).getUsername())) {
          // removes the user
          users.remove(i);
          return true;
        }
      }
    }
    return false;
  }

  /*
   * giveAdmin() method takes in username. Additionally, the method checks to see if the currentUser
   * is an admin. If not, the method doesn't allow the user to use the function of giveAdmin. If so,
   * the method continues to see if the username input equals any other username in the arraylist.
   * If so, then the method sets the user at that index to admin is true.
   * 
   * 
   * @param: String username
   * 
   * @return: boolean representing if the method gave admin to user or not
   * 
   * 
   */

  public boolean giveAdmin(String username) {
    // Give a user admin power
    // checks to see if currentUser is an admin
    if (currentUser.getIsAdmin() == true) {
      for (int i = 0; i < users.size(); i++) {
        // checks if the any of the index in users equals username
        if (username.equals(users.get(i).getUsername())) {
          // sets isAdmin to true
          users.get(i).setIsAdmin(true);
          return true;
        }
      }
    }
    return false;
  }

  /*
   * takeAdmin() method takes in username. Additionally, the method checks to see if the currentUser
   * is an admin. If not, the method doesn't allow the user to use the function of takeAdmin. If so,
   * the method continues to see if the username input equals any other username in the arraylist.
   * If so, then the method sets the user at that index to admin is false.
   * 
   * 
   * @param: String username
   * 
   * @return: boolean representing if the method took admin to user or not
   * 
   * 
   */

  public boolean takeAdmin(String username) {
    // Remove a user's admin power
    if (currentUser == null) {
      return false;
    }
    // checks to see if currentUser is an admin
    if (currentUser.getIsAdmin() == true) {
      for (int i = 0; i < users.size(); i++) {
        // checks if the any of the index in users equals username
        if (username.equals(users.get(i).getUsername())) {
          // sets isAdmin to false
          users.get(i).setIsAdmin(false);
          return true;
        }
      }
    }
    return false;
  }

  /*
   * resetPassword() method takes in a username. Additionally, the method checks to see if the
   * currentUser is an admin or not. If not, the method doesn't execute the function of
   * resetPassword. If so, the method checks to see if the username equals the username of any other
   * index in users arraylist. If so, the method sets the user of that index to the defaultPassword.
   * 
   * 
   * @param: String username
   * 
   * @return: boolean representing if the method reset password or not
   * 
   * 
   */

  public boolean resetPassword(String username) {
    // Reset a user's password
    // checks to see if currentUser is an admin
    if (currentUser.getIsAdmin() == true) {
      for (int i = 0; i < users.size(); i++) {
        // checks if the any of the index in users equals username
        if (username.equals(users.get(i).getUsername())) {
          // sets the password to DEFAULT_PASSWORD
          users.get(i).setPassword(DEFAULT_PASSWORD);
          return true;
        }
      }
    }
    return false;
  }

  /*
   * loginScreen() method initially asks for the username and password and calls sessionScreen if it
   * is a valid login. If not, the method asks for multiple attempts for the login through a while
   * loop.
   * 
   * 
   * @param: Scanner userInputScanner
   * 
   * @return: none
   * 
   * 
   */

  public void loginScreen(Scanner userInputScanner) {
    // Main driver loop.
    // Prompt the user for login information
    // calls the isValidLogin method
    // If the login is valid, call the sessionScreen method
    boolean i = true;
    while (i) {
      System.out.print("Please input your username: ");
      // scans the username
      String u = userInputScanner.nextLine();
      System.out.print("Please input your password: ");
      // scans the password
      String p = userInputScanner.nextLine();
      if (isValidLogin(u, p) == true) {
        // calls sessionScreen
        sessionScreen(u, userInputScanner);
      } else {
        // Login failed
        System.out.println("Invalid Login Credentials");
      }
    }
  }

  /*
   * sessionScreen() takes in username and userInputScanner. The method checks to see if the
   * username is equal to any username in the indexes of the arraylist. If so, the currentUser is
   * equal to the user at that index. The method enters a while loop where the program asks the user
   * for a command for which there is a specific format guided by the different cases below. The
   * method uses a method based off of what command is inputted into the shell. Ultimately, the
   * program executes these commands appropriately.
   * 
   * 
   * @param: String username, Scanner userInputScanner
   * 
   * @return: none
   * 
   * 
   */

  public void sessionScreen(String username, Scanner userInputScanner) {
    // Called when a user is logged in
    // Set the currentUser
    // Allows them to changePassword or logout
    // If they are an admin, gives access to admin methods
    for (int i = 0; i < users.size(); i++) {
      // goes through the arraylist index to see if usernames are equal
      if (users.get(i).getUsername().equals(username)) {
        currentUser = users.get(i);
      }
    }
    boolean i = true;
    while (i) {
      // Prints out Menu
      System.out.println("\nWelcome to the Login Menu " + currentUser.getUsername());
      System.out.println("Please enter an interface command: ");
      String a = userInputScanner.nextLine();

      String[] aArray = a.split(" ");
      // for (String x : aArray) {
      // System.out.println(x);
      // }
      // System.out.println(aArray.length);
      switch (aArray[0]) {
        case "logout":
          // logs user out
          currentUser = null;
          i = false;
          System.out.println("User has logged out");
          break;
        case "newpw":
          // code
          String newPw = aArray[1];
          System.out.println("Changed Password to " + newPw);
          // changes password
          changePassword(newPw);
          break;
        case "adduser":
          boolean isAdmin = false;
          if (aArray.length == 3) {
            if (aArray[2].contains("true")) {
              isAdmin = true;
              System.out.println("Added user " + aArray[1] + " and isAdmin is  " + isAdmin);
              // adds the user with 2 parameters
              addUser(aArray[1], isAdmin);
              break;
            }
          }
          System.out.println("Added user " + aArray[1] + " and isAdmin is " + isAdmin);
          // adds the user with 1 parameter
          addUser(aArray[1]);
          break;
        case "rmuser":
          System.out.println("Removed User " + aArray[1]);
          // removes the user
          removeUser(aArray[1]);
          break;
        case "giveadmin":
          System.out.println("" + aArray[1] + " is now an admin");
          // gives admin power to user
          giveAdmin(aArray[1]);
          break;
        case "rmadmin":
          System.out.println("" + aArray[1] + " is now not an admin");
          // removes admin power from user
          takeAdmin(aArray[1]);
          break;
        case "resetpw":
          System.out.println("Password is reset to " + DEFAULT_PASSWORD);
          // resets password of user
          resetPassword(aArray[1]);
          break;
        default:
          // command is incorrect
          System.out.println("Not a valid command");
          break;
      }
    }
  }

  /*
   * main() method creates an AccessControl object. The method makes the login screen appear and
   * maeks sure the Scanner is functional. The main method acts as a support for the method that
   * actually runs the main code of cases.
   * 
   * 
   * @param: none
   * 
   * @return: none
   * 
   * 
   */

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // creates a new AccessControl object
    AccessControl ac = new AccessControl();
    // If we have any persistent information to lead
    // this is where we load it.
    // creates a Scanner
    Scanner userIn = new Scanner(System.in);
    // calls in the Login
    ac.loginScreen(userIn);
  }

}

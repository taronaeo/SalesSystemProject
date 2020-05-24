/* 
 *  
 *  File: Helper.java
 *  Author: Aaron Teo
 *  Copyright (c) 2020 Aaron Teo
 *  
 */

package SalesSystemProject;

public class Helper {
  public static String repeatString(int n, String s) {
    return new String(new char[n]).replace("\0", s);
  }

  public static void printErrorMessage(String message) {
    System.err.println();
    System.err.println(message);
    System.err.println();
  }
}

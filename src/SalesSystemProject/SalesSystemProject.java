/* 
 *  
 *  File: SalesSystemProject.java
 *  Author: Aaron Teo
 *  Copyright (c) 2020 Aaron Teo
 *  
 */

package SalesSystemProject;

import java.util.Scanner;

public class SalesSystemProject {
  public static void main(String[] args) {
    Computer[] computers = new Computer[10];
    Scanner scanner = new Scanner(System.in);

    int selection = 0;
    int computerCounter = 0;

    while (true) {
      System.out.printf(
        "%s %s %s%n",
        Helper.repeatString(10, "*"),
        "Artificial Intelligence Co.",
        Helper.repeatString(10, "*")
      );

      System.out.println("Computer Menu:");
      System.out.println("1. Add information for new Desktop");
      System.out.println("2. Add information for new Laptop");
      System.out.println("3. Display all computer information");
      System.out.println("4. Quit");

      System.out.println(Helper.repeatString(49, "*"));

      System.out.print("Please enter either 1 to 4: ");

      try {
        selection = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        Helper.printErrorMessage("Selection must be a number!");
        continue;
      }

      switch (selection) {
        case 1:
          computers[computerCounter] = Desktop.addInformation();

          computerCounter++;
          break;
        case 2:
          computers[computerCounter] = Laptop.addInformation();

          computerCounter++;
          break;
        case 3:
          int desktopCount = 0;
          int laptopCount = 0;

          System.out.println();

          for (int i = 0; i < computers.length; i++) {
            if (i == 0 && computers[i] == null) {
              System.err.println("No computers added, yet.");
              System.err.println();
              break;
            }

            if (computers[i] == null) break;

            if (computers[i].computer_id.charAt(0) == 'D') System.out.println("Desktop " + (++desktopCount));
            if (computers[i].computer_id.charAt(0) == 'L') System.out.println("Laptop " + (++laptopCount));

            computers[i].displayInformation();
            System.out.println();
          }
          break;
        case 4:
          System.out.println("Quitting...");
          System.exit(0);
          break;
        default:
          System.err.println("Invalid selection detected");
          System.err.println("Please try again");
          System.err.println();

          break;
      }
    }
  }
}

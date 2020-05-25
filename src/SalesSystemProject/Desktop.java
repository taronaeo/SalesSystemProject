/* 
 *  
 *  File: Desktop.java
 *  Author: Aaron Teo
 *  Copyright (c) 2020 Aaron Teo
 *  
 */

package SalesSystemProject;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Desktop extends Computer {
  public String monitor;

  public Desktop() {
    super();
  }

  @Override
  public void displayInformation() {
    System.out.printf("%-20s: %s%n", "Computer ID", this.computer_id);
    System.out.printf("%-20s: %s%n", "Processor Speed", this.processor_speed);
    System.out.printf("%-20s: %s%n", "RAM", this.ram);
    System.out.printf("%-20s: %s%n", "Hard Disk", this.hard_disk);
    System.out.printf("%-20s: %s%n", "Monitor", this.monitor);
    System.out.printf("%-20s: %.2f%n", "Price", this.price);
  }

  public static Desktop addInformation() {
    Desktop desktop = new Desktop();
    Scanner scanner = new Scanner(System.in);
    Pattern pattern = Pattern.compile("[^A-Za-z0-9]");

    while (true) {
      System.out.println(Helper.repeatString(49, "="));
      System.out.println("Information for new Desktop");
      System.out.println(Helper.repeatString(49, "="));

      System.out.printf("%-28s: ", "What is the Computer ID");
      desktop.computer_id = scanner.nextLine().toUpperCase().trim();

      if (desktop.computer_id.isEmpty()) {
        Helper.printErrorMessage("Computer ID must not be empty!");
        continue;
      }

      if (desktop.computer_id.length() != 4) {
        Helper.printErrorMessage("Computer ID must be exactly 4 characters long!");
        continue;
      }

      if (pattern.matcher(desktop.computer_id).find()) {
        Helper.printErrorMessage("Computer ID must not contain any special characters!");
        continue;
      }

      if (desktop.computer_id.charAt(0) != 'D') {
        Helper.printErrorMessage("Computer ID must start with the character 'D'!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the Processor Speed");
      desktop.processor_speed = scanner.nextLine().trim();

      if (desktop.processor_speed.isEmpty()) {
        Helper.printErrorMessage("Processor Speed must not be empty!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the RAM");
      desktop.ram = scanner.nextLine().trim();

      if (desktop.ram.isEmpty()) {
        Helper.printErrorMessage("RAM must not be empty!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the Hard Disk size");
      desktop.hard_disk = scanner.nextLine().trim();

      if (desktop.hard_disk.isEmpty()) {
        Helper.printErrorMessage("Hard Disk size must not be empty!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the Monitor type: ");
      desktop.monitor = scanner.nextLine().trim().toUpperCase();

      if (desktop.monitor.isEmpty()) {
        Helper.printErrorMessage("Monitor type must not be empty!");
        continue;
      }

      if (!(desktop.monitor.equals("CRT") || desktop.monitor.equals("LCD"))) {
        Helper.printErrorMessage("Monitor type must be either CRT or LCD!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the Price: ");

      try {
        desktop.price = Double.parseDouble(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        Helper.printErrorMessage("Price must be a number!");
        continue;
      }

      if (desktop.price < 0) {
        Helper.printErrorMessage("Price must not be a negative number!");
        continue;
      }

      System.out.println();
      System.out.println("Your information has been added successfully.");
      System.out.println();

      return desktop;
    }
  }
}

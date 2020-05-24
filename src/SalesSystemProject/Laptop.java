/* 
 *  
 *  File: Laptop.java
 *  Author: Aaron Teo
 *  Copyright (c) 2020 Aaron Teo
 *  
 */

package SalesSystemProject;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Laptop extends Computer {
  public double weight;

  public Laptop() {
    super();
  }

  @Override
  public void displayInformation() {
    System.out.printf("%-20s: %s%n", "Computer ID", this.computer_id);
    System.out.printf("%-20s: %s%n", "Processor Speed", this.processor_speed);
    System.out.printf("%-20s: %s%n", "RAM", this.ram);
    System.out.printf("%-20s: %s%n", "Hard Disk", this.hard_disk);
    System.out.printf("%-20s: %.1f%n", "Weight", this.weight);
    System.out.printf("%-20s: %.2f%n", "Price", this.price);
  }

  public static Laptop addInformation() {
    Laptop laptop = new Laptop();
    Scanner scanner = new Scanner(System.in);
    Pattern pattern = Pattern.compile("[^A-Za-z0-9]");

    while (true) {
      System.out.println(Helper.repeatString(49, "*"));
      System.out.println("Information for new Laptop");
      System.out.println(Helper.repeatString(49, "*"));

      System.out.printf("%-28s: ", "What is the Computer ID");
      laptop.computer_id = scanner.nextLine().toUpperCase().trim();

      if (laptop.computer_id.isEmpty()) {
        Helper.printErrorMessage("Computer ID must not be empty!");
        continue;
      }

      if (laptop.computer_id.length() != 4) {
        Helper.printErrorMessage("Computer ID must be exactly 4 characters long!");
        continue;
      }

      if (pattern.matcher(laptop.computer_id).find()) {
        Helper.printErrorMessage("Computer ID must not contain any special characters!");
        continue;
      }

      if (laptop.computer_id.charAt(0) != 'L') {
        Helper.printErrorMessage("Computer ID must start with the character 'D'!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the Processor Speed");
      laptop.processor_speed = scanner.nextLine().trim();

      if (laptop.processor_speed.isEmpty()) {
        Helper.printErrorMessage("Processor Speed must not be empty!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the RAM");
      laptop.ram = scanner.nextLine().trim();

      if (laptop.ram.isEmpty()) {
        Helper.printErrorMessage("RAM must not be empty!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the Hard Disk size");
      laptop.hard_disk = scanner.nextLine().trim();

      if (laptop.hard_disk.isEmpty()) {
        Helper.printErrorMessage("Hard Disk size must not be empty!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the Weight");

      try {
        laptop.weight = Double.parseDouble(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        Helper.printErrorMessage("Weight must be a number!");
        continue;
      }

      if (laptop.weight < 0) {
        Helper.printErrorMessage("Weight must not be a negative number!");
        continue;
      }

      System.out.printf("%-28s: ", "What is the Price");

      try {
        laptop.price = Double.parseDouble(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        Helper.printErrorMessage("Price must be a number!");
        continue;
      }

      if (laptop.price < 0) {
        Helper.printErrorMessage("Price must not be a negative number!");
        continue;
      }

      System.out.println();
      System.out.println("Your information has been added successfully.");
      System.out.println();

      return laptop;
    }
  }
}

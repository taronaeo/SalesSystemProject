/* 
 *  
 *  File: Computer.java
 *  Author: Aaron Teo
 *  Copyright (c) 2020 Aaron Teo
 *  
 */

package SalesSystemProject;

public class Computer {
  public String computer_id;
  public String processor_speed;
  public String ram;
  public String hard_disk;
  public double price;

  /*
   * [Computer] is the default
   * constructor for the class
   * Computer itself.
   *
   * @return An instance of
   * class Computer
   */
  public Computer() {}

  /*
   * [displayInformation] function
   * displays all the information
   * currently available in the
   * Computer class
   *
   * @return Nothing; void
   */
  public void displayInformation() {
    System.out.printf("Computer ID: %s%n", this.computer_id);
    System.out.printf("Processor Speed: %s%n", this.processor_speed);
    System.out.printf("RAM: %s%n", this.ram);
    System.out.printf("Hard Disk: %s%n", this.hard_disk);
    System.out.printf("Price: %.2f%n", this.price);
  }
}

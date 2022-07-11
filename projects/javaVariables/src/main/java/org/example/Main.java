package org.example;

public class Main {
    public static void main(String[] args)
// should always use lowerCamelCase for variable names in java
    // variable names are case sensative
    // vaiable names has to start with a letter
    // cannot have white space between variable names
    int passengers;  // declaring a variable
    passengers = 0; // insializing a value to the variable
    passengers = passengers + 5; //when updating a variable call the variable name then assign it a value. Computer reads right to left
    passengers = passengers -3;
    passengers = passengers -1 +5;
    System.out.println(passengers);

    /*
    Note that Java allows you to write multiple instructions in the same statement!

Updating vs Setting variables
When changing a variable value, you could either set it to a new value all together, or update it based on its previous value.

For example, if we have a variable called time and we want to add 5 to it, we write:

time = time + 5;

This will Add 5 to whatever value time already had!

But if we want to set time to 5 without caring about what the current value was, we write:

time = 5;
     */

}
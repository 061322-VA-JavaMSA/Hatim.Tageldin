package org.example;


public class StringVariable {
    String driver; // declaring a variable of type string
    driver = "tom"; // intitlazing the variable or assigning a value
    int letters = driver.length(); //assigning the value on the driver's variable to an int variable to get the number count
    System.out.println(letters);

    // String Concatenation is joining string together to make a longer string.
    String driverFirstName; // Declared a variable
    driverFirstName = "Hatim "; // insilized it
    String driverLastName; // delcarted a variable
    driverLastName = " Tag"; // intialized it
    String driverFullName = driverFirstName + " " + driverLastName; // delcared a variable and concatenate/joined it with two more variable.
    System.out.println(driverFullName); // system output of the joined strings

}

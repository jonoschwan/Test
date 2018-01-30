import java.io.*;
import java.util.*;

/**
 * Jonathan Schwan
 * CS1450
 * Assignment 2
 * Due: Jan 31 2018
 * This program reads the vehicles.txt file and creates the appropriate vehicle objects
 * then prints their names and sounds(according to which vehicle subclass they are)
 */
public class Assignment2 {

    public static void main(String[] args) throws IOException{

        File file = new File("vehicles.txt"); //Lets file be opened
        Scanner readFile = new Scanner(file); //scanner to read the file

        int sizeOfArray = readFile.nextInt(); //sets int to first number in file
        Vehicle[] vehicleArray = new Vehicle[sizeOfArray]; //creates polymorphic array with size of int in file

        //For loop to add vehicles into correct subclass, array, and set name
        for (int i = 0; i < sizeOfArray; i++) {

            String categoriser = readFile.next(); //String used to hold char to be sorted into correct vehicle type
            String name = readFile.nextLine(); //String that holds vehicle[i]'s name

            if (categoriser.startsWith("b")){ //Buses
                vehicleArray[i] = new Bus();

            } else if (categoriser.startsWith("c")){ //Cars
                vehicleArray[i] = new Car();

            } else if (categoriser.startsWith("h")){ //Helicopter
                vehicleArray[i] = new Helicopter();

            } else if (categoriser.startsWith("m")){ //Motorcycle
                vehicleArray[i] = new Motorcycle();

            } else if (categoriser.startsWith("t")){ //Train
                vehicleArray[i] = new Train();

            } else { //Just incase there is something in the file that is not one of the above vehicles
                System.out.println("Not a recognized vehicle...");
            }

            vehicleArray[i].setName(name); //set's name to Vehicle

        }

        //Loop to to go through vehicle array and print name and sound of each.
       for (Vehicle i : vehicleArray) {
            System.out.println(i.getName() + ": " + i.makeSound() + "\n"); //gets name & prints name and sound
        }

        readFile.close(); //Closes file scanner
    }
}

//Parent Vehicle class
class Vehicle {
    private String name; //stores name of vehicle

    //Constructor
    public String Vehicle(String vehicleName){
        this.name = vehicleName;
        return this.name;
    }

    //Getter
    public String getName(){
        return name;
    }

    //Setter
    public void setName(String name){
        this.name = name;
    }

    //Vehicle Sound Method
    public String makeSound(){
        String vehicleSound = "";
        return vehicleSound;
    }

}

//Helicopter subclass and sound
class Helicopter extends Vehicle {
    @Override public String makeSound() {
        String sound = "Whop-whop-whop";
        return sound;
    }
}

//Train subclass and sound
class Train extends Vehicle {
    @Override public String makeSound() {
        String sound = "Chooga-chooga-chooga";
        return sound;
    }
}

//Car subclass and sound
class Car extends Vehicle {
    @Override public String makeSound() {
        String sound = "Vroom-vroom-vroom";
        return sound;
    }
}

//Motorcycle subclass and sound
class Motorcycle extends Vehicle {
    @Override public String makeSound() {
        String sound = "Bom-bom-bom";
        return sound;
    }
}

//Bus subclass and sound
class Bus extends Vehicle {
    @Override public String makeSound() {
        String sound = "Rum-rum-rum-rummm";
        return sound;
    }
}
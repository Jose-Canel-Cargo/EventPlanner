// Course:     COP-2805C-86399 Java Advanced                                                                               //
// Assignment: Project 3: Demonstrate OOP Principles for Inheritance                                                       //
// Date:       February 18th, 2024                                                                                         //
// Name:       Jose A. Cañellas Torres                                                                                     //
// Purpose:    The purpose of this program is to allow an user to create a number of events                                //
//             of ther choice from 3 options, Event, Birthday, or Quinceañera.                                             //
//             For this, 3 Classes were made with the corresponding names with the parent class                            //
//             being Event, BirthdayParty is a child class of Event, and Quinceanera is a                                  //
//             child class of BirthdayParty.                                                                               //
//                                                                                                                         //
//             While the user is being prompted for the details of each event, most methods call                           //
//             a method inside Event to present the user with their entry and allow them to make corrections.              //
//             Another method with the same purpose, but for integers, was made and successfully implemented.              //
//             At the end, the details for each event created will be displayed.                                           //

import java.util.Scanner;

public class EventPlanner {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // Declaring values for the number of events and the event choices while initializing //
        // the counter variables for the while loops.                                         //
        int numberOfEvents = 0;
        int eventChoiceInput;
        int eventCounter = 0;
        int eventDetailsCounter = 0;
        String eventChoice = ":\n1.Event\n2.Birthday\n3.Quinceanera\n"; // String of the event choices to reduce repetition //

        // Prints the information of the developer and the class //
        System.out.println("\n**Course: COP-2805C-86399**\n**Assignment: Project 3: Demonstrate OOP Principles for Inheritance**\n**Date: February 18th, 2024**\n**Name: Jose A. Canellas Torres**\n");

        // Prompts the user for the amount of events they wish to create //
        System.out.print("\nEnter the amount of events that you wish to create: ");

        // Boolean so the while loop below may continue until set to true //
        boolean validIntegerInput = false;

        // While loop to verify the user has entered an integer //
        while (!validIntegerInput) {

            if (scanner.hasNextInt()) {

                numberOfEvents = scanner.nextInt(); // Sets the user's input as the number of Event objects to be created //
                scanner.nextLine(); // Used for a common bug that would happen where acceptance of input was skipped //
                validIntegerInput = true; // Boolean set as True to leave the while loop //

            } else {

                // If the user did not enter an integer, the following error will be displayed and it will prompt for input again //
                System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                scanner.nextLine();
                System.out.print("\nEnter the amount of events that you wish to create: ");
            }
        } 

        // Generates the array of Class Objects depending on the user input //
        Event[] eventArray = new Event[numberOfEvents];
        

        // While loop to request the user to assign the type of events to all the Class Objects created //
        while(eventCounter < numberOfEvents){

            System.out.print("\nChoose the type of event for Event " + (eventCounter + 1) + eventChoice);
            System.out.print("\nChoice: ");

            // Checks to make sure that the input is an integer, if not it will display the invalid input error in the last else statement and loop back //
            if (scanner.hasNextInt()){
                
                eventChoiceInput = scanner.nextInt();

                // Makes sure the input is from 1-3, if not it skips to the outside of range error and loops back //
                if (eventChoiceInput >= 1 && eventChoiceInput <= 3) {

                    switch (eventChoiceInput) {

                        case 1:
                            eventArray[eventCounter] = new Event(scanner); // Creates an Event Object //
                            break;

                        case 2:
                            eventArray[eventCounter] = new BirthdayParty(scanner); // Creates a BirthdayParty Object //
                            break;

                        case 3:
                            eventArray[eventCounter] = new Quinceanera(scanner); // Creates a Quinceanera Object //
                            break;

                    }

                    eventCounter++; // Adds 1 to the counter for this loop //
                    
                } else {

                    // Error displayed if the user's input is outside of the range of allowed inputs //
                    System.out.println("\nYour choice is invalid. Please enter a number between 1 and 3 to pick an event type.\n");

                }

            } else {

                // Error displayed if the user's input is not an integer //
                System.out.println("\nYour input is invalid. Please enter a number.\n");
                scanner.nextLine();
            }
        }

        System.out.print("\nNow, let's fill in the details for your requested events.\n");
        scanner.nextLine(); // Added to avoid a bug like mentioned above //

        // While loop that calls the allSetMethods method of each Class so the user may fill out their details //
        while(eventDetailsCounter < numberOfEvents){

            System.out.print("\nEvent #" + (eventDetailsCounter + 1));
            eventArray[eventDetailsCounter].allSetMethods();
            eventDetailsCounter++;
        }

        System.out.println("\nHere are the details for every Event:\n");
        eventDetailsCounter = 0;

        // While loop that will go through each element of the array and display their details //
        while(eventDetailsCounter < numberOfEvents) {

            System.out.print(eventArray[eventDetailsCounter].toString());
            eventDetailsCounter++;
        }
       
        // Closes scanner //
        scanner.close();
    }
}

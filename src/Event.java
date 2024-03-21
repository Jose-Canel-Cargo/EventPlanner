import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Event {
    
    // Declaring all the variables for the Event Class//
    public Scanner scanner; // Scanner variable used by all subclasses //
    protected String eventName; // String for the event's name //
    protected String eventDate; // String for the event's date //
    protected LocalTime eventStartTime; // LocalTime variable for the start time used to have user input with the correct format //
    protected String eventStartTimeString; // Formatted String variable of the start time //
    protected LocalTime eventEndTime; // LocalTime variable similar to the start time above with the same purpose //
    protected String eventEndTimeString; // Formatted String variable for the end time with the same purpose as eventStartTimeString //
    protected String eventLocationName; // String for the event's location //
    protected String eventLocationAddress; // String for the location's address /
    protected int eventNumberOfGuests; // String of the number of guests, chosen so it may go through the inputCorrection method //
    protected String eventPointOfContact; // String of the Point of Contact for the event //
    protected String eventPrice; // String for the event's price //

    // Constructor method that accepts a scanner variable //
    public Event(Scanner scanner){
        
        this.scanner = scanner;
    }

    // Setter method for the event's name //
    public void setEventName(){
                
        System.out.print("\nWhat is the Name of the Event?: ");
        //scanner.nextLine();
        String eventNameInput = scanner.nextLine(); 

        eventName = inputCorrection("Event Name", eventNameInput); // Allows the user to correct their input if necessary // 
    }

    // Getter method for the event's name //
    public String getEventName(){
        
        return eventName;
    }

    // Setter method for the event's date //
    public void setEventDate(){

        boolean validDateFormat = false; // Declared boolean variable for the date format verification while loop //
        while (!validDateFormat){

            // Prompts user for the date of the event //
            System.out.print("\nEnter the Date when " + eventName + " will take place (Day/Month/Year): ");

            String inputEventDate = scanner.nextLine();

            // If statement that will run until validInputDate confirms the input is valid //
            if (validInputDate(inputEventDate)){
                this.eventDate =  inputEventDate;
                validDateFormat = true;

            } else{
                // Error displayed if the input is invalid or out of range //
                System.out.print("\nYour input is in an invalid format. Please enter a valid date" +
                 " using the formatting (Day/Month/Year)\nExample: (11/12/2024)\n");
            }
        }
    }

    // Getter method for the event's date //
    public String getEventDate(){
        
        return eventDate;
    }

    // Setter method for the event's start time //
    public void setEventStartTime(){

        // Integer variables used when the hour and minutes are extracted from the input for the purpose of formatting //
        int eventHour;
        int eventMinutes;
        String formattedStartTime; // The formatted start time will be assigned to this variable //
        
        boolean validStartTime = false; // Boolean for the while loop below //

        // While loop that runs until validStartTime is set to true //
        while (!validStartTime){

            // Prompts the user for the start time //
            System.out.print("\nEnter the Start Time of " + eventName + " using the following Format (HH:MM) *Example: 09:59*: ");
            String inputStartTime = scanner.nextLine();

            // Try and Catch blocks to handle the formatting of the start time //
            try {
                // The start time must pass the parse method with the formatting of HH:MM or the exception below will trigger //
                this.eventStartTime = LocalTime.parse(inputStartTime);
                validStartTime = true;

            } catch (DateTimeParseException exception){

                // Displays error when the format of the input is invalid //
                System.out.print("\nYour formatting was invalid. Please use the Format (HH:MM) *Example: 05:00*\n");
            }
        }

        eventHour = eventStartTime.getHour(); // Gets the hour from the input //
        eventMinutes = eventStartTime.getMinute(); // Gets the minutes from the input //

        boolean validMorningOrEveningInput = false; // Boolean for the while loop below asking the user if the event takes place in the AM or PM //

        // While loop that runs until the boolean variable is set to true //
        while (!validMorningOrEveningInput){
            
            // Prompts user to enter AM or PM //
            System.out.print("\nAM or PM?: ");
            String startMorningOrEveningInput = scanner.nextLine().trim(); // Assigns input to the String variable and trims excess spaces //

            // If statement that verifies that the input is valid (either AM or PM) //
            if (startMorningOrEveningInput.equalsIgnoreCase("AM") ) {
                formattedStartTime = String.format("%02d:%02d AM", eventHour %12,  eventMinutes); // Formats the time and adds AM at the end of the String //
                this.eventStartTimeString = formattedStartTime;
                validMorningOrEveningInput = true;

            } else if (startMorningOrEveningInput.equalsIgnoreCase("PM")){
                formattedStartTime = String.format("%02d:%02d PM", eventHour %12,  eventMinutes); // Formats the time and adds PM at the end of the String //
                this.eventStartTimeString = formattedStartTime;
                validMorningOrEveningInput = true;

            } else {

                // If input is neither AM or PM then this error will display //
                System.out.print("\nInvalid input. Enter 'AM' or 'PM'.\n");

            }
        }
    }

    // Getter method for the event's start time //
    public String getEventStartTime(){

        return eventStartTimeString;
    }

    // Setter method that does the same thing as setEventStartTime but for the end time                   //
    // Was planning on making a method to contain the process of both setter methods to remove repetition //
    // but due to time constraints I will attempt to resubmit before or after grading if implemented      //
    // successfully.                                                                                      //
    public void setEventEndTime(){

        int eventHour;
        int eventMinutes;
        String formattedEndTime;
        
        boolean validEndTime = false;
        while (!validEndTime){
            System.out.print("\nEnter the End Time of " + eventName +  " using the following Format (HH:MM) *Example: 09:59*: ");
            String endTimeInput = scanner.nextLine();

            try {
                this.eventEndTime = LocalTime.parse(endTimeInput);
                validEndTime = true;

            } catch (DateTimeParseException exception){

                System.out.println("\nYour formatting was invalid. Please use the Format (HH:MM) *Example: 05:00*\n");
            }
        }

        eventHour = eventEndTime.getHour();
        eventMinutes = eventEndTime.getMinute();

        boolean validMorningOrEveningInput = false;
        while (!validMorningOrEveningInput){
            
            System.out.print("\nAM or PM?: ");
            String endMorningOrEveningInput = scanner.nextLine().trim();

            if (endMorningOrEveningInput.equalsIgnoreCase("AM")) {
                formattedEndTime = String.format("%02d:%02d AM", eventHour %12,  eventMinutes);
                this.eventEndTimeString = formattedEndTime;
                validMorningOrEveningInput = true;

            } else if (endMorningOrEveningInput.equalsIgnoreCase("PM")) {
                formattedEndTime = String.format("%02d:%02d PM", eventHour %12,  eventMinutes);
                this.eventEndTimeString = formattedEndTime;
                validMorningOrEveningInput = true;

            } else {
                System.out.println("\nInvalid input. Enter 'AM' or 'PM'.\n");

            }
        }
    }

    // Getter method for the event's end time //
    public String getEventEndTime(){
       
        return eventEndTimeString;
    }

    // Setter method for the name of the event's location, uses the inputCorrection method //
    public void setLocationName(){

        // Prompts the user for the name of the location //
        System.out.print("\nEnter the Name of the Location for " + eventName + ": ");
        String locationInput = scanner.nextLine();

        eventLocationName = inputCorrection("Name of the Location", locationInput); // Allows the user to correct their input if necessary //        
    }

    // Getter method for the name of the event's location //
    public String getLocationName(){
        return eventLocationName;
    }

    // Setter method for the address of the event's location //
    public void setLocationAddress(){

        // Prompts the user for the location's address //
        System.out.print("\nEnter the Address for " + eventLocationName + "?: ");
        String addressInput = scanner.nextLine();

        eventLocationAddress = inputCorrection("Location Address", addressInput); // Allows the user to correct their input if necessary //
    }

    // Getter method for the location's address //
    public String getLocationAddress(){
        return eventLocationAddress;
    }   

    // Setter method for the number of guests attending the event //
    public void setNumberOfGuests(){
        boolean validGuestInput = false; // Boolean for the while loop below //

        // Prompts the user for the amount of guests //
        System.out.print("\nEnter the Amount of Guests expected for " + eventName + ": ");

        // While loop to make sure the input is an integer and calls the integerInputCorrection method if so //
        while (!validGuestInput) {

            // If the input is an integer this if statement will run and set the boolean to true at the end //
            if (scanner.hasNextInt()) {

                int guestNumberInput = scanner.nextInt();
                scanner.nextLine();
                eventNumberOfGuests = integerInputCorrection("Number of Guests", guestNumberInput); // Allows the user to correct their input if necessary //
                validGuestInput = true;

            } else {

                // If input is not an integer, the following error will be displayed //
                System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                scanner.nextLine();
                System.out.print("\nEnter the Amount of Guests expected for " + eventName + ": ");
            }
        }
        
    }

    // Getter method for the number of guests //
    public int getNumberOfGuests(){

        return eventNumberOfGuests;
    }

    // Setter method for the point of contact of the event //
    public void setPointOfContact(){

        // Prompts the user for the event's point of contact //
        System.out.print("\nEnter the Point of Contact for this event. Use the Formatting (POC Name/Phone Number): ");
        String pointOfContactInput = scanner.nextLine();

        eventPointOfContact = inputCorrection("Point of Contact", pointOfContactInput); // Allows the user to correct their input if necessary //
    }

    // Getter method for the event's point of contact //
    public String getPointOfContact(){
        return eventPointOfContact;
    }

    // Setter method for the event's price of entry //
    public void setEventPrice(){

        // Prompts the user for the price of entry //
        System.out.print("\nEnter the Price of Entry for " + eventName + ": ");
        String eventPriceInput = scanner.nextLine();
        
        eventPrice = inputCorrection("Price of Entry", eventPriceInput); // Allows the user to correct their input if necessary //
        eventPrice = "$" + eventPrice; // Concatenate's a dollar sign to the start of the price //
    }

    // Getter method for the event's price //
    public String getEventPrice(){
        return eventPrice;
    }


    // Input validation method used to setup the event dates //
    private boolean validInputDate(String inputDate){

        // The regular expression that matches the input. First part makes sure the date is in the range //
        // of 1-9, then 10-29, and finally 30 or 31. Second part makes sure the month is in the range of //
        // 1-9 and then 10-12. Final part makes sure the year starts with 20 and that is in the range of //
        // 2020-2099. (This was the hardest part for me, thank you Chapted 10 and Appendix H)            //

        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/20[2-9]\\d$";
        return inputDate.matches(regex);// Returns true or false depending of the result of the matching //
    }

    // Method use for input correction, accepts a parameter for the variable's name and the input for it //
    public String inputCorrection(String fieldName, String userInput ){

        // Variables for the method //
        boolean finishedCorrection = false; // boolean used in the first while loop //
        String inputToCorrect = userInput; // String that is returned after the input is corrected, if necessary //
        String confirmInput; // String variable used for confirmation of needs for correction //

        // While loop that stops when the user confirms no further need of correction //
        while(!finishedCorrection){

            // Prompts the user to confirm if they want to make corrections or not //
            System.out.print("\nThe " + fieldName + " you wrote was [" + userInput + "]. Do you wish to make changes? \n" + 
            "(Type 'Yes' to make changes or 'No' to continue): ");
            String yesOrNoInput = scanner.nextLine().trim();

            // If loop that runs if the user indicated they need to make corrections //
            if (yesOrNoInput.equalsIgnoreCase("yes")) {

                boolean correctedInput = false;// Boolean used in the while loop below //

                // While loop that allows user to make corrections, exits when the user indicates no further corrections are needed //
                while(!correctedInput) {

                    // Prompts user for the corrected input //
                    System.out.print("\nEnter the correct " + fieldName + ": ");
                    inputToCorrect = scanner.nextLine();

                    // Shows user their entered correction and asks to confirm if it is now correct or not //
                    System.out.print("\nYou wrote [" + inputToCorrect + "] for " + fieldName + ". Is this correct?" + "\n(Type 'Yes' to Confirm or 'No' to Re-Enter): ");
                    confirmInput = scanner.nextLine().trim();

                    // If user confirms it is correct, correctedInput is set to true and exits the while loop //
                    if(confirmInput.equalsIgnoreCase("yes")) {

                        correctedInput = true;

                    // If user indicates it is still not correct, it loops back to ask for the correct input //
                    } else if (confirmInput.equalsIgnoreCase("no")) {

                        correctedInput = false; // Placed simply to show that the boolean remains as false, not necessary //

                    
                    } else {
                        
                        // Error displayed if the user enters something other than yes or no when asked for confirmation //
                        System.out.print("\nYour input was invalid. Please enter either 'Yes' or 'No'.");
                        correctedInput = false;
                    }
                }

                finishedCorrection = true; // Sets Boolean to true if corrections are done //

            } else if (yesOrNoInput.equalsIgnoreCase("no")) {

                finishedCorrection = true; // Sets Boolean to true if no corrections were needed //

            } else {

                // Error displayed if the user enters something other than yes or no when asked for confirmation //
                System.out.print("Your input was invalid. Please enter either 'Yes' or 'No'.");
            }
        }        
        return inputToCorrect; // Returns the input after correction or as is if no corrections were needed //     
    }


    // Method use for input correction, accepts a parameter for the variable's name and the input for it //
    public int integerInputCorrection(String fieldName, int userInput ){

        // Variables for the method //
        boolean finishedCorrection = false; // boolean used in the first while loop //
        int inputToCorrect = userInput; // Input that is returned after the input is corrected, if necessary //
        String confirmInput; // String variable used for confirmation of needs for correction //

        // While loop that stops when the user confirms no further need of correction //
        while(!finishedCorrection){

            // Prompts the user to confirm if they want to make corrections or not //
            System.out.print("\nThe " + fieldName + " you wrote was [" + userInput + "]. Do you wish to make changes? \n" + 
            "(Type 'Yes' to make changes or 'No' to continue): ");
            String yesOrNoInput = scanner.nextLine().trim();

            // If loop that runs if the user indicated they need to make corrections //
            if (yesOrNoInput.equalsIgnoreCase("yes")) {

                boolean correctedInput = false; // Boolean used in the while loop below //
                

                // While loop that allows user to make corrections, exits when the user indicates no further corrections are needed //
                while(!correctedInput) {

                    // Prompts user for the corrected input //
                    System.out.print("\nEnter the correct " + fieldName + ": ");

                    boolean validInput = false; // Boolean used in the inner while loop below//

                    // While loop that verifies validity of the corrected input, makes sure its an integer before assigning //
                    while (!validInput){

                        if (scanner.hasNextInt()) {

                            inputToCorrect = scanner.nextInt();
                            scanner.nextLine();
                            validInput = true;

                        } else {

                            System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                            System.out.print("\nEnter the correct " + fieldName + ": ");
                            scanner.nextLine();
                        }
                    }

                    // Shows user their entered correction and asks to confirm if it is now correct or not //
                    System.out.print("\nYou wrote [" + inputToCorrect + "] for " + fieldName + ". Is this correct?" + "\n(Type 'Yes' to Confirm or 'No' to Re-Enter): ");
                    confirmInput = scanner.nextLine().trim();

                    // If user confirms it is correct, correctedInput is set to true and exits the while loop //
                    if(confirmInput.equalsIgnoreCase("yes")) {

                        correctedInput = true; // Sets boolean to true so loop can be escaped //

                    // If user indicates it is still not correct, it loops back to ask for the correct input //
                    } else if (confirmInput.equalsIgnoreCase("no")) {

                        correctedInput = false; // Placed simply to show that the boolean remains as false, not necessary //

                    
                    } else {
                        
                        // Error displayed if the user enters something other than yes or no when asked for confirmation //
                        System.out.print("\nYour input was invalid. Please enter either 'Yes' or 'No'.");
                        correctedInput = false;
                    }
                }

                finishedCorrection = true; // Sets Boolean to true if corrections are done //

            } else if (yesOrNoInput.equalsIgnoreCase("no")) {

                finishedCorrection = true; // Sets Boolean to true if no corrections were needed //

            } else {

                // Error displayed if the user enters something other than yes or no when asked for confirmation //
                System.out.print("Your input was invalid. Please enter either 'Yes' or 'No'.");
            }
        }        
        return inputToCorrect; // Returns the input after correction or as is if no corrections were needed //     
    }

    // Method that runs all the event setter methods one after the other //
    public void allSetMethods(){
        
        setEventName();
        setEventDate();
        setEventStartTime();
        setEventEndTime();
        setLocationName();
        setLocationAddress();
        setNumberOfGuests();
        setPointOfContact();
        setEventPrice();
    }

    // toString method that displays all the details of the event with the user's input //
    public String toString(){

        return "\nEvent Details:\n" + "\nEvent Name: " + getEventName() + "\nEvent Date: " + 
        getEventDate() + "\nEvent Start Time: " + getEventStartTime() + "\nEvent End Time: " +
        getEventEndTime() + "\nEvent Location: " + getLocationName() + "\nEvent Address: " +
        getLocationAddress() + "\nNumber of Guests: " + getNumberOfGuests() + "\nPoint of Contact: " +
        getPointOfContact() + "\nPrice of Entry: " + getEventPrice() + "\n";
    }
}

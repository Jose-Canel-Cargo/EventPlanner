import java.util.Scanner;

public class BirthdayParty extends Event{

    // Variables for the BirthdayParty Class //
    protected String birthdayName; // String for the celebrant's name //
    protected int birthdayAge; // Integer for the celebrated age //
    protected String birthdayCake; // String for the type of cake //
    protected int numberOfCandles; // Integer for the number of candles on the cake //
    protected String birthdayDecorations; // String for the theme of the decorations //

    // Constructor method for BirthdayParty, accepting the scanner from Event as a parameter //
    public BirthdayParty(Scanner scanner) {

        super(scanner);
    }

    // Setter method for the celebrant's name //
    public void setBirthdayName(){
        
        // Prompts the user for the celebrant's name //
        System.out.print("\n\nEnter the Name of the person celebrating their birthday: ");
        String birthdayNameInput = scanner.nextLine();

        birthdayName = inputCorrection("Celebrant's Name", birthdayNameInput); // Allows the user to correct their input if necessary //

        this.eventName = birthdayName + "'s Birthday Party"; // Concatenates the celebrant's name with "'s Birthday Party" to create an eventName for the object //

    }

    // Getter method for the celebrant's name //
    public String getBirthdayName(){

        return birthdayName;
    }

    // Setter method for the age being celebrated //
    public void setBirthdayAge(){
        Boolean validBirthdayAge = false; // Boolean for the while loop below //

        // Prompts the user for the birthday age //
        System.out.print("\nWhat age is " + birthdayName + " going to be?: ");

        // While loop to make sure the input is an integer and calls the integerInputCorrection method if so //
        while (!validBirthdayAge) {

            // If the input is an integer this if statement will run and set the boolean to true at the end //
            if (scanner.hasNextInt()) {

                int birthdayAgeInput = scanner.nextInt();
                scanner.nextLine();
                birthdayAge = integerInputCorrection( "age of " + this.eventName, birthdayAgeInput);
                validBirthdayAge = true;

            } else {

                // If input is not an integer, the following error will be displayed //
                System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                scanner.nextLine();
                System.out.print("\nWhat age is " + birthdayName + " going to be?: ");

            }
        }

    }

    // Getter method for the age being celebrated //
    public int getBirthdayAge(){

        return birthdayAge;
    }

    // Setter method for the type of cake //
    public void setBirthdayCake(){

        // Prompts the user for the type of birthday cake //
        System.out.print("\nEnter the Type of Cake for " + this.eventName + ": ");
        String birthdayCakeInput = scanner.nextLine();

        birthdayCake = inputCorrection("Type of Cake", birthdayCakeInput); // Allows the user to correct their input if necessary //
    }

    // Getter method for the type of cake //
    public String getBirthdayCake(){

        return birthdayCake;
    }

    // Setter method for the number of candles //
    public void setNumberOfCandles(){
        boolean validCandleInput = false;

        // Prompts the user for the number of candles //
        System.out.print("\nEnter the Number of Candles for the Cake: ");

        // While loop to make sure the input is an integer and calls the integerInputCorrection method if so //
        while (!validCandleInput) {

            // If the input is an integer this if statement will run and set the boolean to true at the end //
            if (scanner.hasNextInt()){

                int numberOfCandlesInput = scanner.nextInt();
                scanner.nextLine();
                numberOfCandles = integerInputCorrection("Number of Candles", numberOfCandlesInput);
                validCandleInput = true;

            } else {

                // If input is not an integer, the following error will be displayed //
                System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                scanner.nextLine();
                System.out.print("\nEnter the Number of Candles for the Cake: ");
            }
        }
    }

    // Getter method for the number of candles //
    public int getNumberOfCandles(){

        return numberOfCandles;
    }

    // Setter method for the theme of decorations //
    public void setDecorations(){

        // Prompts the user for the theme of the decorations //
        System.out.print("\nEnter the Theme for the Decorations in " + this.eventName + ": ");
        String birthdayDecorationsInput = scanner.nextLine();

        birthdayDecorations = inputCorrection("Theme of Decorations", birthdayDecorationsInput); // Allows the user to correct their input if necessary //

    }

    // Getter method for the theme of decorations //
    public String getDecorations(){

        return birthdayDecorations;
    }


    // Overriden allSetMethod with the set methods for BirthdayParty added and event's price setter method removed //
    @Override
    public void allSetMethods(){

        setBirthdayName();
        setBirthdayAge();
        setBirthdayCake();
        setNumberOfCandles();
        setDecorations();
        setEventDate();
        setEventStartTime();
        setEventEndTime();
        setLocationName();
        setLocationAddress();
        setNumberOfGuests();
        setPointOfContact();

    }

    // Overriden toString method to display the details of the Birthday //
    @Override
    public String toString(){

        return "\n" + getEventName() +" Details:\n" + "\nCelebrant's Name: " + getBirthdayName() + "\nAge of Celebration: " +
        getBirthdayAge() + "\nCake of Choice: " + getBirthdayCake() + "\nNumber of Candles for the Cake: " + getNumberOfCandles() +
        "\nTheme for Decorations: " + getDecorations() + "\nDate of Celebration: " + getEventDate() +
        "\nBirthday Start Time: " + getEventStartTime() + "\nCelebration End Time: " + getEventEndTime() + 
        "\nBirthday Location: " + getLocationName() + "\nBirthday Location Address: " + getLocationAddress() + 
        "\nNumber of Guests: " + getNumberOfGuests() + "\nPoint of Contact: " + getPointOfContact() + "\n";
    }

    
    
}

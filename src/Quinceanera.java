import java.util.Scanner;

public class Quinceanera extends BirthdayParty{

    // Variables for the Quinceañera Class //
    private int numberOfDamas; // Integer for the number of Damas //
    private int numberOfChambelanes; // Integer for the number of Chambelanes //
    private int numberOfToasts; // Integer for the number of toasts //
    private String danceMusicChoice; // String for the choice of music for the dance /

    // Constructor method that accepts a scanner as parameter and sets the birthday age to 15 //
    public Quinceanera(Scanner scanner) {

        super(scanner);
        this.birthdayAge = 15; // Automatically sets the age to 15 when a Quinceanera Object is created //
    }

    // Overriden setBirthdayName method so it asks for Quinceañera's name instead //
    @Override
    public void setBirthdayName(){

        // Prompts the user for the Quinceañera's name //
        System.out.print("\nEnter the Quinceañera's Name: ");
        String quinceaneraNameInput = scanner.nextLine();

        // Allows the user to correct their input if necessary //
        this.birthdayName = inputCorrection("Quinceañera's Name", quinceaneraNameInput); 

        // Concatenates "'s Quinceañera" at the end of the Quinceañera's name and assigns the result to the eventName of this object //
        this.eventName = birthdayName + "'s Quinceañera"; 
    }

    // Setter method for the number of Damas //
    public void setNumberOfDamas(){
        boolean validDamasInput = false; // Boolean for the while loop below //

        // Prompts the user for the number of Damas //
        System.out.print("\nEnter the Number of Damas that will assist " + this.birthdayName + ": ");

        // While loop to make sure the input is an integer and calls the integerInputCorrection method if so //
        while (!validDamasInput) {

            // If the input is an integer this if statement will run and set the boolean to true at the end //
            if (scanner.hasNextInt()) {

                int numberOfDamasInput = scanner.nextInt();
                scanner.nextLine();
                numberOfDamas = integerInputCorrection("Number of Damas", numberOfDamasInput);
                validDamasInput = true;

            } else {

                // If input is not an integer, the following error will be displayed //
                System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                scanner.nextLine();
                System.out.print("\nEnter the Number of Damas that will assist " + this.birthdayName + ": ");
                
            }
        }
    }

    // Getter method for the number of Damas //
    public int getNumberOfDamas(){

        return numberOfDamas;
    }

    // Setter method for the number of Chambelanes //
    public void setNumberOfChambelanes(){
        boolean validChambelanesInput = false;

        // Prompts the user for the number of Chambelanes //
        System.out.print("\nEnter the Number of Chambelanes that will assist " + this.birthdayName + ": ");

        // While loop to make sure the input is an integer and calls the integerInputCorrection method if so //
        while (!validChambelanesInput) {

            // If the input is an integer this if statement will run and set the boolean to true at the end //
            if (scanner.hasNextInt()) {

                int numberOfChambelanesInput = scanner.nextInt();
                scanner.nextLine();
                numberOfChambelanes = integerInputCorrection("Number of Chambelanes", numberOfChambelanesInput);
                validChambelanesInput = true;

            } else {

                // If input is not an integer, the following error will be displayed //
                System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                scanner.nextLine();
                System.out.print("\nEnter the Number of Chambelanes that will assist " + this.birthdayName + ": ");

            }
        }
    }

    // Getter method for the number of Chambelanes //
    public int getNumberOfChambelanes(){

        return numberOfChambelanes;
    }

    // Setter method for the number of toasts //
    public void setNumberOfToasts(){
        boolean validToastsInput = false; // Boolean for the while loop below //

        // Prompts the user for the number of toasts //
        System.out.print("\nEnter the Number of Toasts that will be given in " + this.eventName + ": ");

        // While loop to make sure the input is an integer and calls the integerInputCorrection method if so //
        while (!validToastsInput) {

            // If the input is an integer this if statement will run and set the boolean to true at the end //
            if (scanner.hasNextInt()) {

                int numberOfToastsInput = scanner.nextInt();
                scanner.nextLine();
                numberOfToasts = integerInputCorrection("Number of Toasts", numberOfToastsInput);
                validToastsInput = true;

            } else {

                // If input is not an integer, the following error will be displayed //
                System.out.println("\nYour input was invalid. Please enter a numerical value.\n");
                scanner.nextLine();
                System.out.print("\nEnter the Number of Toasts that will be given in " + this.eventName + ": ");

            }
        }
    }

    // Getter method for the number of toasts //
    public int getNumberOfToasts(){

        return numberOfToasts;
    }

    // Setter method for the dance music //
    public void setDanceMusic(){

        // Prompts the user for the dance music, allows them to enter multiple if necessary //
        System.out.print("\nEnter the Music of Choice for the Dance. Use commas to separate each Genre(if applicabble): ");
        String musicChoiceInput = scanner.nextLine();

        danceMusicChoice = inputCorrection("Music Choice", musicChoiceInput);

    }

    // Getter method for the dance music //
    public String getDanceMusic(){

        return danceMusicChoice;
    }

    // Overriden allSetMethods method with all the set methods necessary from Event, BirthdayParty, and Quinceanera //
    @Override
    public void allSetMethods(){

        setBirthdayName();
        setNumberOfDamas();
        setNumberOfChambelanes();
        setNumberOfToasts();
        setBirthdayCake();
        setNumberOfCandles();
        setDecorations();
        setDanceMusic();
        setEventDate();
        setEventStartTime();
        setEventEndTime();
        setLocationName();
        setLocationAddress();
        setNumberOfGuests();
        setPointOfContact();

    }

    // Overriden toString method to display the details of the Quinceanera //
    @Override
    public String toString(){

        return "\n" + getEventName() + " Details:\n" + "\nQuinceañera's Name: " + getBirthdayName() + 
        "\nAge of Celebration: " + getBirthdayAge() + "\nNumber of Damas: " + getNumberOfDamas() + 
        "\nNumber of Chambelanes: " + getNumberOfChambelanes() + "\nNumber of Toasts: " + getNumberOfToasts() +
        "\nCake of Choice: " + getBirthdayCake() + "\nNumber of Candles For The Cake: " + getNumberOfCandles() + 
        "\nTheme for Decorations: " + getDecorations() + "\nGenres of Music For Dance: " +
        getDanceMusic() + "\nDate of The Quinceañera: " + getEventDate() + "\nQuinceañera Start Time: " +
        getEventStartTime() + "\nQuinceañera End Time: " + getEventEndTime() + 
        "\nQuinceañera Location Name: " + getLocationName() + "\nQuinceañera Location Address: " +
        getLocationAddress() + "\nNumber of Guests: " + getNumberOfGuests() + 
        "\nPoint of Contact: " + getPointOfContact() + "\n";
    }
    
}

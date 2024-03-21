# Program Requirements:

For this project, four classes had to be made:

- Event: Has a date, start and end time, location name and address, event name, number of guests, point of contact, and price.
- BirthdayParty: BirthdayParty must extend Event and have an age, cake, candles, and decorations.
- Quinceanera: Quinceanera must extend BirthdayParty and have number of damas, number of toasts performed, and choice of dance music. Age should be immutably set to 15.
- EventPlanner: Includes the runnable main() method in which the desired number of events and their type will be created by the user.

An array of type Event must be created when the user enters how many events they wish to create. Then the user will assign a type to each event
so that the appropriate Class object is created and added to the array. Finally, the program must loop through the array so the user is allowed
to enter the details for each event created.

## Purpose:

When run, the user will be prompted to choose for the amount of events they desire to create and their type. After this is done, the user
will fill in the details for every one of the events and then a report is printed showing the details for every event.
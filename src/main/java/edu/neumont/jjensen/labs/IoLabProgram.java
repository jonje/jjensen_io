package edu.neumont.jjensen.labs;

import inputhelper.InputHelpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/28/13
 * Time: 9:05 AM
 */
public class IoLabProgram {

    private boolean isRunning;
    private Scanner input;
    private FileIO fileIO;
    private ArrayList<Contact> currentContacts;

    private MenuOption[] menuOptions = {
            new MenuOption("Exit", new Actionable() {
                @Override
                public void performAction() {
                    exit();
                }
            }),

            new MenuOption("Display Contacts", new Actionable() {
                @Override
                public void performAction() {
                    displayAllContacts();
                }
            }),

            new MenuOption("Display Specific Contact", new Actionable() {
                @Override
                public void performAction() {
                    displaySpecificContact();
                }
            }),

            new MenuOption("Add New Contact", new Actionable() {
                @Override
                public void performAction() {
                    createNewContact();
                }
            })


    };



    private final String GREETING = "Welcome to contact Viewer\nCreated by: Jonathan Jensen\nCopyright 2013\n";

    /**
     * Default constructor setups up the user input stream.
     */
    public IoLabProgram() {
        input = new Scanner(System.in);
        fileIO = new FileIO("/home/jjensen/Projects/Java/jjensen_io/src/main/resources/Contacts.csv");
        currentContacts = new ArrayList<Contact>();
    }




    public void run() {
        isRunning = true;
        displayGreeting(GREETING);
        loadContacts();


        do{
            displayMenu();
            int choice = promptAndGetOptionChoice();
            if(isValidChoice(choice)) {
                menuOptions[choice].performAction();

            }

        } while(isRunning);
    }

    private void displaySpecificContact() {
        loadContacts();
        InputHelpers.promptUser("Enter contact id(Ex: 1 ):");
        Contact contact = currentContacts.get(InputHelpers.extractInt(InputHelpers.getUserInput(input)));

        System.out.println("Name: " + contact.getName());
        System.out.println("Email: " + contact.getEmailAddress());
        System.out.println("Phone: " + contact.getPhoneNumber());
    }

    private void displayAllContacts() {
        loadContacts();

        for(int i = 1; i < currentContacts.size(); i++) {
            System.out.println(i + " - " + currentContacts.get(i).getName());
        }

        System.out.println();
    }

    private void loadContacts() {

        fileIO.loadFile();
        fileIO.createContactsList();
        currentContacts = new ArrayList<Contact>();
        Iterator<Contact> contacts = fileIO.getContactList();

        while(contacts.hasNext()) {
            currentContacts.add(contacts.next());

        }

    }

    private boolean isValidChoice(int choice) {
        return choice <= menuOptions.length;

    }

    private void exit(){
        isRunning = false;
        System.out.println("\nGood bye!");
    }

    private void displayMenu() {
        for(int i = 0; i < menuOptions.length; i++) {
            System.out.println(i + ". " + menuOptions[i].getName());
        }
    }

    private int promptAndGetOptionChoice() {
        InputHelpers.promptUser("Please enter numerical choice:");
        return InputHelpers.extractInt(InputHelpers.getUserInput(input));
    }

    private void displayGreeting(String greeting) {
        int padding = 2;
        String[] greetings = greeting.split("\n");
        for(int i = 0; i < greeting.length() + padding; i++) {
            System.out.print("*");
        }


        System.out.println("\n " + greeting + " \n");

        for(int i = 0; i < greeting.length() + padding; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    private void createNewContact() {
        InputHelpers.promptUser("\nEnter contact name: ");
        String name = InputHelpers.getUserInput(input);

        InputHelpers.promptUser("Enter contact email: ");
        String email = InputHelpers.getUserInput(input);

        InputHelpers.promptUser("Enter phone number: ");
        String phone = InputHelpers.getUserInput(input);

        currentContacts.add(new Contact(name, email, phone));
        fileIO.writeFile(currentContacts);

        System.out.println("\nContact created!");
    }


}

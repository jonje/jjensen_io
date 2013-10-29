package edu.neumont.jjensen.labs;

import inputhelper.InputHelpers;

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
    private MyFileReader fileReader;
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
            })


    };

    private final String GREETING = "Welcome to contact Viewer\nCreated by: Jonathan Jensen\nCopyright 2013\n";

    /**
     * Default constructor setups up the user input stream.
     */
    public IoLabProgram() {
        input = new Scanner(System.in);
        fileReader = new MyFileReader("/home/jjensen/Projects/Java/jjensen_io/src/main/resources/Contacts.csv");
    }




    public void run() {
        isRunning = true;
        displayGreeting(GREETING);

        do{
            displayMenu();
            int choice = propmptAndGetOptionChoice();
            if(isValidChoice(choice)) {
                menuOptions[choice].performAction();

            }

        } while(isRunning);
    }

    private void displayAllContacts() {
        getContacts();
        Iterator<Contact> contacts = fileReader.getContactList();
        fileReader.displayFile();




    }

    private void getContacts() {

        fileReader.loadFile();
        fileReader.createContactsList();
    }

    private boolean isValidChoice(int choice) {
        return choice <= menuOptions.length ? true : false;

    }

    private void exit(){
        isRunning = false;
    }

    private void displayMenu() {
        for(int i = 0; i < menuOptions.length; i++) {
            System.out.println(i + ". " + menuOptions[i].getName());
        }
    }

    private int propmptAndGetOptionChoice() {
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


}

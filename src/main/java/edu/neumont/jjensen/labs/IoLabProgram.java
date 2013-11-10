package edu.neumont.jjensen.labs;

import inputhelper.InputHelpers;

import java.util.*;

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
    private List<Contact> currentContacts;

    private MenuOption[] menuOptions = {
            new MenuOption("Exit", new Actionable() {
                @Override
                public void performAction() {
                    exit();
                }
            }),

            new MenuOption("Print persons sorted by Name", new Actionable() {
                @Override
                public void performAction() {
                    displayPersonNameSort();
                }
            }),

            new MenuOption("Print persons sorted by PhoneNumber", new Actionable() {
                @Override
                public void performAction() {
                    displayPersonPhoneSort();
                }
            }),

            new MenuOption("Print persons sorted by Birth Date", new Actionable() {
                @Override
                public void performAction() {
                    displayPersonBirthdateSort();
                }
            }),

            new MenuOption("Get a single person by Name", new Actionable() {
                @Override
                public void performAction() {
                    displaySpecificContact();
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
        currentContacts = new ArrayList<>();
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

    private void displayPersonNameSort() {
        Collections.sort(currentContacts, Contact.NAME_ORDER);
        displayAllContacts();
    }

    private void displayPersonPhoneSort() {
        Collections.sort(currentContacts, Contact.PHONE_ORDER);
        displayAllContacts();
    }

    private void displayPersonBirthdateSort() {
        Collections.sort(currentContacts, Contact.BIRTHDATE_ORDER);
        displayAllContacts();
    }

    private void displaySpecificContact() {
        InputHelpers.promptUser("Enter contact name(Ex: James Url ):");
        String name = InputHelpers.getUserInput(input);
        Contact contact = findContact(name);

        System.out.println("Name: " + contact.getName());
        System.out.println("Email: " + contact.getBirthDate());
        System.out.println("Phone: " + contact.getPhoneNumber());
    }

    private Contact findContact(String name) {

        Contact contact = new Contact("Not Found", "000-000-0000", "00/00/0000");

        for (Contact contactCheck : currentContacts) {
            if(contactCheck.getName().equalsIgnoreCase(name)) {
                contact = contactCheck;
            }
        }

        return contact;
    }

    private void displayAllContacts() {


        for(int i = 1; i < currentContacts.size(); i++) {
            System.out.println(currentContacts.get(i).toString());
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

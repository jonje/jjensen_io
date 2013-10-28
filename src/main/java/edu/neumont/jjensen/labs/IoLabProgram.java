package edu.neumont.jjensen.labs;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/28/13
 * Time: 9:05 AM
 */
public class IoLabProgram {

    private boolean isRunning;


    public void run() {
        isRunning = true;

        do{

        } while(isRunning);
    }
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
                    displayContacts();
                }
            })


    };

    private void displayContacts() {

    }

    private void exit(){
        isRunning = false;
    }


}

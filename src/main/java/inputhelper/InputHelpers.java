package inputhelper;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/21/13
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class InputHelpers {

    public static int extractInt(String input) {
        int integer = 0;

        try {
            integer = Integer.parseInt(input);

        } catch (NumberFormatException exception) {

        }

        return integer;
    }

    /**
     *
     * @param message
     */
    public static void promptUser(String message) {
        System.out.println(message);

    }

    /**
     * Used to collect user input returning a string of their input
     * @return userInput (String)
     */
    public static String getUserInput(Scanner input) {

        return input.nextLine();

    }
}

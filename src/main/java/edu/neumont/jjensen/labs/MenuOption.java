package edu.neumont.jjensen.labs;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/28/13
 * Time: 8:42 AM
 */
public class MenuOption implements MenuOptional {
    private String name;
    private Actionable action;

    public MenuOption(String name, Actionable action ) {
        this.name = name;
        this.action = action;

    }

    @Override
    public void performAction() {
        action.performAction();
    }

    public String getName() {
        return name;
    }
}

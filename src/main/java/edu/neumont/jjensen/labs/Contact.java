package edu.neumont.jjensen.labs;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/28/13
 * Time: 8:32 AM
 */
public class Contact {

    private String name;
    private String emailAddress;
    private String phoneNumber;

    public Contact (String name, String emailAddress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package edu.neumont.jjensen.labs;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/28/13
 * Time: 8:32 AM
 */
public class Contact implements Comparable{

    private String name;
    private Date birthDate;
    private String phoneNumber;

    public Contact (String name, String birthDate, String phoneNumber) {
        this.name = name;
        this.birthDate = new Date(birthDate);
        this.phoneNumber = phoneNumber;



    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

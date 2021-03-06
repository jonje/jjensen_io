package edu.neumont.jjensen.labs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/28/13
 * Time: 8:32 AM
 */
public class Contact implements Comparable<Contact> {

    private String name;
    private Date birthDate;
    private String phoneNumber;
    private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");

    public Contact (String name, String phoneNumber, String birthDate) {
        this.name = name;

        try{

            this.birthDate = dateFormat.parse(birthDate);

        } catch(ParseException parseException) {
            parseException.printStackTrace();
        }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!birthDate.equals(contact.birthDate)) return false;
        if (!name.equals(contact.name)) return false;
        if (!phoneNumber.equals(contact.phoneNumber)) return false;

        return true;
    }

    @Override
    public String toString() {
        return  name + " " + dateFormat.format(birthDate) +
                " " + phoneNumber ;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    @Override
    public int compareTo(Contact contact) {
        return 0;
    }

    public static final Comparator<Contact> BIRTHDATE_ORDER = new Comparator<Contact>() {
        @Override
        public int compare(Contact contact1, Contact contact2) {
            return contact1.getBirthDate().compareTo(contact2.getBirthDate());
        }
    };

    public static final Comparator<Contact>  PHONE_ORDER = new Comparator<Contact>() {
        @Override
        public int compare(Contact contact1, Contact contact2) {
            return contact1.getPhoneNumber().compareTo(contact2.getPhoneNumber());
        }
    };

    public static final Comparator<Contact> NAME_ORDER = new Comparator<Contact>() {
        @Override
        public int compare(Contact contact1, Contact contact2) {
            return contact1.getName().compareTo(contact2.getName());
        }
    };
}

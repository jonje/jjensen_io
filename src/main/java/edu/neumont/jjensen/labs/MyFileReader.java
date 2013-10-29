package edu.neumont.jjensen.labs;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/29/13
 * Time: 8:21 AM
 */
public class MyFileReader {
    private File filePath;
    private ArrayList<String> fileLines;
    private ArrayList<Contact> contactList;

    public MyFileReader(String filePath) {

        fileLines = new ArrayList<String>();
        contactList = new ArrayList<Contact>();

        this.filePath = new File(filePath);

    }

    public void loadFile() {
        try(BufferedReader fileReader = new BufferedReader( new FileReader(filePath))) {

            while(fileReader.ready()) {
                fileLines.add(fileReader.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println("File Successfully loaded");
    }

    public void createContactsList() {
        for(String line : fileLines) {
            String[] values = line.split(",");
            contactList.add(new Contact(values[0], values[1], values[2]));

        }
    }

    public Iterator<Contact> getContactList() {
        return contactList.iterator();
    }

    public void displayFile() {
        for(String line : fileLines) {
            System.out.println(line);
        }
    }



}

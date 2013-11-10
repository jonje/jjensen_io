package edu.neumont.jjensen.labs;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jjensen
 * Date: 10/29/13
 * Time: 8:21 AM
 */
public class FileIO {
    private File filePath;
    private List<String> fileLines;
    private List<Contact> contactList;

    public FileIO(String filePath) {

        fileLines = new ArrayList<>();
        contactList = new ArrayList<>();

        this.filePath = new File(filePath);

    }

    public void loadFile() {
        fileLines = new ArrayList<>();
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
        contactList = new ArrayList<Contact>();
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

    public void writeFile(List<Contact> contacts) {


        BufferedWriter fileWriter = null;

        try {

            filePath.createNewFile();
            fileWriter = new BufferedWriter(new FileWriter(filePath));

            for(Contact contact : contacts) {
                fileWriter.write(contact.getName() + "," + contact.getBirthDate() + "," + contact.getPhoneNumber());
                fileWriter.newLine();
                fileWriter.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();

        } finally {

                if(fileWriter != null) {
                    try {
                        fileWriter.close();

                    } catch (IOException e) {
                        e.printStackTrace();

                    }

                }

        }


    }



}

package com.addressbook.AddressBookApp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact person) {
        contacts.add(person);
        System.out.println("Contact Added Successfully");
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void displayContacts() {
        for (Contact person : contacts) {
            person.display();
        }
    }

    public void editContact(String firstName) {

        for (Contact contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Editing Contact: " + firstName);

                System.out.println("Enter new Address:");
                contact.setAddress(scanner.nextLine());

                System.out.println("Enter new City:");
                contact.setCity(scanner.nextLine());

                System.out.println("Enter new State:");
                contact.setState(scanner.nextLine());

                System.out.println("Enter new Zip:");
                contact.setZip(scanner.nextLine());

                System.out.println("Enter new Phone Number:");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter new Email:");
                contact.setEmail(scanner.nextLine());

                System.out.println("Contact Updated Successfully");

                return;
            }
        }

        System.out.println("Contact not found");
    }

    public void deleteContact(String firstName) {

        Contact contactToDelete = null;

        for (Contact contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                contactToDelete = contact;
                break;
            }
        }

        if (contactToDelete != null) {
            contacts.remove(contactToDelete);
            System.out.println("Contact deleted successfully");
        } else {
            System.out.println("Contact not found");
        }


    }
}

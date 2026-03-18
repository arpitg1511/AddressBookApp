package com.addressbook.AddressBookApp.service;

import com.addressbook.AddressBookApp.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    private List<Contact> contacts = new ArrayList<>();

    public Contact addContact(Contact contact) {
        contacts.add(contact);
        return contact;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public Contact getContactByName(String firstName) {

        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                return contact;
            }
        }

        return null;
    }

    public Contact editContact(String firstName, Contact updatedContact) {

        for (Contact contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                contact.setAddress(updatedContact.getAddress());
                contact.setCity(updatedContact.getCity());
                contact.setState(updatedContact.getState());
                contact.setZip(updatedContact.getZip());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                contact.setEmail(updatedContact.getEmail());

                return contact;
            }
        }

        return null;
    }

    public String deleteContact(String firstName) {

        Contact contactToDelete = null;

        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                contactToDelete = contact;
                break;
            }
        }

        if (contactToDelete != null) {
            contacts.remove(contactToDelete);
            return "Contact Deleted Successfully";
        }

        return "Contact Not Found";
    }
}
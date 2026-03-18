package com.addressbook.AddressBookApp.controller;

import com.addressbook.AddressBookApp.model.Contact;
import com.addressbook.AddressBookApp.service.AddressBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return service.addContact(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return service.getAllContacts();
    }

    @GetMapping("/{name}")
    public Contact getContact(@PathVariable String name) {
        return service.getContactByName(name);
    }

    @PutMapping("/{name}")
    public Contact updateContact(@PathVariable String name,
                                 @RequestBody Contact contact) {

        return service.editContact(name, contact);
    }

    @DeleteMapping("/{name}")
    public String deleteContact(@PathVariable String name) {
        return service.deleteContact(name);
    }
}
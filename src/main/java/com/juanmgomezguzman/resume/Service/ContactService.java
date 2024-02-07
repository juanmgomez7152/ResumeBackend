package com.juanmgomezguzman.resume.Service;

import com.juanmgomezguzman.resume.Model.Contact;
import com.juanmgomezguzman.resume.Repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactService {

    private final Logger logger = LoggerFactory.getLogger(ContactService.class);


    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        try {
            logger.info("Saving contact: {}", contact);
            return contactRepository.save(contact);
        } catch (Exception e) {
            // Add logging and handle exceptions appropriately
            logger.error("Error saving contact", e);
            e.printStackTrace();
            throw new RuntimeException("Failed to save contact.");
        }
    }

    public Contact getContactById(String id) {
        try {
            logger.info("Retrieving contact by ID: {}", id);
            Optional<Contact> optionalContact = contactRepository.findById(id);
            return optionalContact.orElse(null);
        } catch (Exception e) {
            logger.error("Error retrieving contact by ID", e);
            // Add logging and handle exceptions appropriately
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve contact by ID.");
        }
    }

    public Iterable<Contact> getAllContacts() {
        try {
            return contactRepository.findAll();
        } catch (Exception e) {
            // Add logging and handle exceptions appropriately
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve all contacts.");
        }
    }

    public void deleteContactById(String id) {
        try {
            contactRepository.deleteById(id);
        } catch (Exception e) {
            // Add logging and handle exceptions appropriately
            e.printStackTrace();
            throw new RuntimeException("Failed to delete contact by ID.");
        }
    }
}

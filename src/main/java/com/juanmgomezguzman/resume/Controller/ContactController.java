package com.juanmgomezguzman.resume.Controller;

import com.juanmgomezguzman.resume.Model.Contact;
import com.juanmgomezguzman.resume.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        // Validate the incoming contact data
        if (contact == null || contact.getName() == null || contact.getEmail() == null) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request
        }

        try {
            Contact createdContact = contactService.saveContact(contact);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
        } catch (Exception e) {
            // Log the exception and return a 500 Internal Server Error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable String id) {
        try {
            Contact contact = contactService.getContactById(id);
            if (contact != null) {
                return ResponseEntity.ok(contact);
            } else {
                return ResponseEntity.notFound().build(); // Return 404 Not Found
            }
        } catch (Exception e) {
            // Log the exception and return a 500 Internal Server Error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ... other methods

}

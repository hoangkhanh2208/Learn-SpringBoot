package com.hoangkhanh.restapidemo.api;

import java.util.List;

import com.hoangkhanh.restapidemo.model.Contact;
import com.hoangkhanh.restapidemo.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class RestApiController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("contact")
    public ResponseEntity<List<Contact>> listAllContact() {
        List<Contact> listContact = contactService.findAll();
        if (listContact.isEmpty()) {
            return new ResponseEntity<List<Contact>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Contact>>(listContact, HttpStatus.OK);
    }
    
    @GetMapping("contact/{id}")
    public Contact findContact(@PathVariable("id") long id) {
        Contact contact = contactService.getById(id);
        if (contact == null) {
            ResponseEntity.notFound().build();
        }
        return contact;
    }

    @PostMapping("contact")
    public Contact saveContact(@Valid @RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @PutMapping("contact")
    public ResponseEntity<Contact> updateContact(@PathVariable(value = "id") Long contactId,
            @Valid @RequestBody Contact contactForm) {
        Contact contact = contactService.getById(contactId);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }
        contact.setName(contactForm.getName());
        contact.setAge(contactForm.getAge());

        Contact updateContact = contactService.save(contact);
        return ResponseEntity.ok(updateContact);
    }
    
    @DeleteMapping("contact/{id}")
    public ResponseEntity<Contact> deleteContact(@PathVariable(value = "id") Long id) {
        Contact contact = contactService.getById(id);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }
        contactService.delete(contact);
        return ResponseEntity.ok().build();
    }
}

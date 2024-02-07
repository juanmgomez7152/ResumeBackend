package com.juanmgomezguzman.resume.Repository;
import com.juanmgomezguzman.resume.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContactRepository extends JpaRepository<Contact, String> {
    
}

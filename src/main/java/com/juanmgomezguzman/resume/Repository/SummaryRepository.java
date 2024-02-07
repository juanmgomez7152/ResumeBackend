package com.juanmgomezguzman.resume.Repository;
import com.juanmgomezguzman.resume.Model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SummaryRepository extends JpaRepository<Summary, Integer> {
    
}

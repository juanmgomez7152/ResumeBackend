package com.juanmgomezguzman.resume.Service;

import com.juanmgomezguzman.resume.Model.Summary;
import com.juanmgomezguzman.resume.Repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummaryService {

    @Autowired
    private SummaryRepository summaryRepository;

    public Summary saveSummary(Summary summary) {
        try {
            return summaryRepository.save(summary);
        } catch (Exception e) {
            // Add logging and handle exceptions appropriately
            e.printStackTrace();
            throw new RuntimeException("Failed to save summary.");
        }
    }

    public Summary getSummaryById(Integer id) {
        try {
            Optional<Summary> optionalSummary = summaryRepository.findById(id);
            return optionalSummary.orElse(null);
        } catch (Exception e) {
            // Add logging and handle exceptions appropriately
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve summary by ID.");
        }
    }

    public Iterable<Summary> getAllSummaries() {
        try {
            return summaryRepository.findAll();
        } catch (Exception e) {
            // Add logging and handle exceptions appropriately
            e.printStackTrace();
            throw new RuntimeException("Failed to retrieve all summaries.");
        }
    }

    public void deleteSummaryById(Integer id) {
        try {
            summaryRepository.deleteById(id);
        } catch (Exception e) {
            // Add logging and handle exceptions appropriately
            e.printStackTrace();
            throw new RuntimeException("Failed to delete summary by ID.");
        }
    }
}

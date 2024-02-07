package com.juanmgomezguzman.resume.Controller;

import com.juanmgomezguzman.resume.Model.Summary;
import com.juanmgomezguzman.resume.Service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/summaries")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    @PostMapping
    public ResponseEntity<Summary> createSummary(@RequestBody Summary summary) {
        // Validate the incoming summary data
        if (summary == null || summary.getContent() == null) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request
        }

        try {
            Summary createdSummary = summaryService.saveSummary(summary);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdSummary);
        } catch (Exception e) {
            // Log the exception and return a 500 Internal Server Error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Summary> getSummaryById(@PathVariable Integer id) {
        try {
            Summary summary = summaryService.getSummaryById(id);
            if (summary != null) {
                return ResponseEntity.ok(summary);
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

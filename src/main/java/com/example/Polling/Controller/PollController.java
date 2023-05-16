package com.example.Polling.Controller;

import com.example.Polling.Modle.PollCreationRequest;
import com.example.Polling.Service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("polls")
public class PollController {

    @Autowired
    private PollService pollService;


    @PostMapping
    public ResponseEntity<String> createPoll(@RequestBody PollCreationRequest request) {
        pollService.createPoll(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Poll created successfully.");
    }

    @PostMapping("vote")
    public ResponseEntity<String> voteOnPoll(
            @PathVariable Long pollId,
            @RequestParam String choice
    ) {
        pollService.voteOnPoll(pollId, choice);
        return ResponseEntity.ok("Vote recorded successfully.");
    }
}

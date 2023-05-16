package com.example.Polling.Service;

import com.example.Polling.Modle.PollCreationRequest;
import com.example.Polling.Modle.PollEntity;
import com.example.Polling.Modle.Vote;
import com.example.Polling.Repository.PollRepository;
import com.example.Polling.Repository.VoteRepository;
import org.apache.tomcat.jni.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;
    @Autowired
    private VoteRepository voteRepository;
    public void createPoll(PollCreationRequest request) {
        PollEntity poll = new PollEntity();
        poll.setQuestion(request.getQuestion());
        poll.setChoices(request.getChoices());
        pollRepository.save(poll);
    }

    public void voteOnPoll(Long pollId, String choice) {
        PollEntity poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new NoSuchElementException("Poll not found with ID: " + pollId));

        if (!poll.getChoices().contains(choice)) {
            throw new IllegalArgumentException("Invalid choice for poll with ID: " + pollId);
        }

        Vote vote = new Vote();
        vote.setPoll(poll);
        vote.setChoice(choice);

        voteRepository.save(vote);

        System.out.println("Vote recorded for poll with ID: " + pollId);
    }
}



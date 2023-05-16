package com.example.Polling.Modle;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Poll;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private PollEntity poll;

    @Column(nullable = false)
    private String choice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}


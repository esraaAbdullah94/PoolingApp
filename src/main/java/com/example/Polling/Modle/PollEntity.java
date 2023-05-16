package com.example.Polling.Modle;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "polls")
public class PollEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    @ElementCollection
    @CollectionTable(name = "poll_choices", joinColumns = @JoinColumn(name = "poll_id"))
    @Column(name = "choice")
    private List<String> choices;
}


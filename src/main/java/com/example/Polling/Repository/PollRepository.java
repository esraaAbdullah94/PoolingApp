package com.example.Polling.Repository;

import com.example.Polling.Modle.PollEntity;
import org.apache.tomcat.jni.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<PollEntity, Long> {

}


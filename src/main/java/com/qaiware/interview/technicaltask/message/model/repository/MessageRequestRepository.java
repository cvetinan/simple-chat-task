package com.qaiware.interview.technicaltask.message.model.repository;

import com.qaiware.interview.technicaltask.message.model.entity.MessageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRequestRepository extends JpaRepository<MessageRequest, Long> {
}
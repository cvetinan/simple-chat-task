package com.qaiware.interview.technicaltask.message.service;

import com.qaiware.interview.technicaltask.message.model.dto.MessageDTO;
import com.qaiware.interview.technicaltask.message.model.entity.MessageRequest;
import com.qaiware.interview.technicaltask.message.model.repository.MessageRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@Transactional
public class MessageRequestService {

    private final MessageRequestRepository messageRequestRepository;

    @Autowired
    public MessageRequestService(MessageRequestRepository messageRequestRepository) {
        this.messageRequestRepository = messageRequestRepository;
    }

    public MessageRequest create(@Valid MessageDTO messageDTO) {
        MessageRequest messageRequest = MessageRequest.builder()
                .type(messageDTO.getType())
                .payload(messageDTO.getPayload())
                .build();

        return this.messageRequestRepository.save(messageRequest);
    }
}

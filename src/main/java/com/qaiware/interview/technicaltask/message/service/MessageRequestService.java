package com.qaiware.interview.technicaltask.message.service;

import com.qaiware.interview.technicaltask.message.model.entity.MessageRequest;
import com.qaiware.interview.technicaltask.message.model.dto.MessageRequestBindingModel;
import com.qaiware.interview.technicaltask.message.model.repository.MessageRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MessageRequestService {

    private final MessageRequestRepository messageRequestRepository;

    @Autowired
    public MessageRequestService(MessageRequestRepository messageRequestRepository) {
        this.messageRequestRepository = messageRequestRepository;
    }

    public MessageRequest create(MessageRequestBindingModel messageRequestBindingModel) {
        MessageRequest messageRequest = MessageRequest.builder()
                .type(messageRequestBindingModel.getType())
                .payload(messageRequestBindingModel.getPayload())
                .build();

        return this.messageRequestRepository.save(messageRequest);
    }
}

package com.qaiware.interview.technicaltask.message.service;

import com.qaiware.interview.technicaltask.message.model.dto.MessageRequestBindingModel;
import com.qaiware.interview.technicaltask.message.model.entity.MessageRequest;
import com.qaiware.interview.technicaltask.message.model.repository.MessageRequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageRequestServiceTest {

    @InjectMocks
    private MessageRequestService messageRequestService;
    @Mock
    private MessageRequestRepository messageRequestRepository;

    @Test
    void testCreateSuccessful() {
        final String payload = "Test create payload";
        final String type = "send_text";

        final MessageRequest expectedMessageRequest = MessageRequest.builder()
                .payload(payload)
                .type(type)
                .build();

        when(messageRequestRepository.save(any(MessageRequest.class))).thenReturn(expectedMessageRequest);

        final MessageRequestBindingModel bindingModel = new MessageRequestBindingModel();
        bindingModel.setPayload(payload);
        bindingModel.setType(type);

        final var actualMessageRequest = messageRequestService.create(bindingModel);
        assertThat(actualMessageRequest).usingRecursiveComparison().isEqualTo(expectedMessageRequest);
        verify(messageRequestRepository, times(1)).save(expectedMessageRequest);
        verifyNoMoreInteractions(messageRequestRepository);
    }
}
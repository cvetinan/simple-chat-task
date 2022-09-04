package com.qaiware.interview.technicaltask.message.service;

import com.qaiware.interview.technicaltask.message.model.dto.MessageDTO;
import com.qaiware.interview.technicaltask.message.model.dto.TextMessageDTO;
import com.qaiware.interview.technicaltask.message.model.entity.MessageRequest;
import com.qaiware.interview.technicaltask.message.model.repository.MessageRequestRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class MessageRequestServiceTest {
    private static MessageRequestService messageRequestService;
    private static MessageRequestRepository messageRequestRepository;

    @BeforeAll
    static void setUp() {
        messageRequestRepository = mock(MessageRequestRepository.class);
        messageRequestService = new MessageRequestService(messageRequestRepository);
    }

    @Test
    void testCreateSuccessful() {
        final String payload = "Test create payload";
        final String type = "send_text";

        final MessageRequest expectedMessageRequest = MessageRequest.builder()
                .payload(payload)
                .type(type)
                .build();

        when(messageRequestRepository.save(any(MessageRequest.class))).thenReturn(expectedMessageRequest);

        final MessageDTO bindingModel = new TextMessageDTO(type,payload);

        final var actualMessageRequest = messageRequestService.create(bindingModel);
        assertThat(actualMessageRequest).usingRecursiveComparison().isEqualTo(expectedMessageRequest);
        verify(messageRequestRepository, times(1)).save(expectedMessageRequest);
        verifyNoMoreInteractions(messageRequestRepository);
    }
}
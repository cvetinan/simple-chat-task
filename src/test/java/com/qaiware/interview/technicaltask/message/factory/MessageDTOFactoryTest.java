package com.qaiware.interview.technicaltask.message.factory;

import com.qaiware.interview.technicaltask.message.model.dto.EmotionMessageDTO;
import com.qaiware.interview.technicaltask.message.model.dto.TextMessageDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessageDTOFactoryTest {

    @Test
    void createTextMessageDTO() {
        var textMessageDTO = MessageDTOFactory.createMessageDTO("text");
        assertTrue(textMessageDTO instanceof TextMessageDTO);
    }

    @Test
    void createEmotionMessageDTO() {
        var textMessageDTO = MessageDTOFactory.createMessageDTO("emotion");
        assertTrue(textMessageDTO instanceof EmotionMessageDTO);
    }

    @Test
    void createInvalidMessageDTOShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> MessageDTOFactory.createMessageDTO("invalid"));
    }

}
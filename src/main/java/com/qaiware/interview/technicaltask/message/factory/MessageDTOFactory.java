package com.qaiware.interview.technicaltask.message.factory;

import com.qaiware.interview.technicaltask.message.model.dto.EmotionMessageDTO;
import com.qaiware.interview.technicaltask.message.model.dto.MessageDTO;
import com.qaiware.interview.technicaltask.message.model.dto.TextMessageDTO;

import java.util.Locale;

public final class MessageDTOFactory {

    public static MessageDTO createMessageDTO(String type) {
        switch (type.toLowerCase(Locale.ROOT)) {
            case "text":
                return new TextMessageDTO(type);
            case "emotion":
                return new EmotionMessageDTO(type);
            default:
                throw new IllegalArgumentException("Invalid message type");
        }
    }

    private MessageDTOFactory() {

    }
}

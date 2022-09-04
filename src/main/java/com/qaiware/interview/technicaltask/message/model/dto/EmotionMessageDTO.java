package com.qaiware.interview.technicaltask.message.model.dto;

import com.qaiware.interview.technicaltask.constant.ValidationConstants;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Getter
@Setter
public class EmotionMessageDTO implements MessageDTO {

    @NotEmpty
    private String type;
    @NotEmpty
    @Pattern(regexp = ValidationConstants.Message.EMOTION_MESSAGE_PATTERN)
    private String payload;

    public EmotionMessageDTO(String type) {
        this.type = type;
    }
}

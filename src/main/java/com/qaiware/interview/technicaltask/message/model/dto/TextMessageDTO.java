package com.qaiware.interview.technicaltask.message.model.dto;

import com.qaiware.interview.technicaltask.constant.ValidationConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
public class TextMessageDTO implements MessageDTO {

    @NotEmpty
    private String type;
    @NotEmpty
    @Size(min = ValidationConstants.Message.MIN_TEXT_MESSAGE_LENGTH,
            max = ValidationConstants.Message.MAX_TEXT_MESSAGE_LENGTH)
    private String payload;

    public TextMessageDTO(String type) {
        this.type = type;
    }
}

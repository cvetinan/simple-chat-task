package com.qaiware.interview.technicaltask.message.model.binding;

import com.qaiware.interview.technicaltask.constant.ValidationConstants;
import com.qaiware.interview.technicaltask.message.model.binding.validationgroup.EmotionMessageGroup;
import com.qaiware.interview.technicaltask.message.model.binding.validationgroup.TextMessageGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class MessageRequestBindingModel implements Serializable {
    private static final long serialVersionUID = 42L;

    @Size(min = ValidationConstants.Message.MIN_TEXT_MESSAGE_LENGTH,
            max = ValidationConstants.Message.MAX_TEXT_MESSAGE_LENGTH,
            groups = {TextMessageGroup.class})
    @Pattern(regexp = ValidationConstants.Message.EMOTION_MESSAGE_PATTERN,
            groups = {EmotionMessageGroup.class})
    @NotEmpty(groups = {TextMessageGroup.class, EmotionMessageGroup.class})
    private String payload;
}

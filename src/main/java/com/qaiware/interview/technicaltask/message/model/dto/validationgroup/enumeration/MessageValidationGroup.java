package com.qaiware.interview.technicaltask.message.model.dto.validationgroup.enumeration;

import com.qaiware.interview.technicaltask.message.model.dto.validationgroup.EmotionMessageGroup;
import com.qaiware.interview.technicaltask.message.model.dto.validationgroup.TextMessageGroup;

public enum MessageValidationGroup {
    SEND_TEXT(TextMessageGroup.class),
    SEND_EMOTION(EmotionMessageGroup.class);

    private Class<?> validationGroup;

    MessageValidationGroup(Class<?> validationGroup) {
        this.validationGroup = validationGroup;
    }

    public Class<?> getValidationGroup() {
        return this.validationGroup;
    }

}

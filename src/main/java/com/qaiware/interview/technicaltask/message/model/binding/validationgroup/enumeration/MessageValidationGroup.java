package com.qaiware.interview.technicaltask.message.model.binding.validationgroup.enumeration;

import com.qaiware.interview.technicaltask.message.model.binding.validationgroup.EmotionMessageGroup;
import com.qaiware.interview.technicaltask.message.model.binding.validationgroup.TextMessageGroup;

public enum MessageValidationGroup {
    TEXT(TextMessageGroup.class),
    EMOTION(EmotionMessageGroup.class);

    private Class<?> validationGroup;

    MessageValidationGroup(Class<?> validationGroup) {
        this.validationGroup = validationGroup;
    }

    public Class<?> getValidationGroup() {
        return this.validationGroup;
    }
}

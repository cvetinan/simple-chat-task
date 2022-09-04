package com.qaiware.interview.technicaltask.message.model.dto;

public interface MessageDTO {

    String getType();

    String getPayload();

    void setPayload(final String payload);
}

package com.qaiware.interview.technicaltask.constant;

public final class ValidationConstants {

    public final static class Message {
        public static final int MIN_TEXT_MESSAGE_LENGTH = 1;
        public static final int MAX_TEXT_MESSAGE_LENGTH = 160;
        public static final String EMOTION_MESSAGE_PATTERN = "^\\D{2,10}$";
        public static final String MESSAGE_TYPE_PATH_PATTERN = "(^\\/messages\\/(?:send_text|send_emotion)$)";

        private Message() {
        }
    }

    private ValidationConstants() {
    }
}

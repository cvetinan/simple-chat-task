package com.qaiware.interview.technicaltask.message.controller;

public final class ValidationConstantsPayload {

    static final class ValidTextMessagePayload {
        static final String VALID_PAYLOAD_SEND_TEXT = "{\"payload\":\"This is valid send_text payload\"}";
        static final String VALID_PAYLOAD_SEND_TEXT_MIN_LENGTH = "{\"payload\":\"T\"}";
        static final String VALID_PAYLOAD_SEND_TEXT_MAX_LENGTH = "{\"payload\":\"Lorem ipsum dolor sit amet, consectetuer " +
                "adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus " +
                "et magnis dis parturient.\"}";
    }

    static final class InvalidTextMessagePayload {
        static final String INVALID_PAYLOAD_SEND_TEXT_ABOVE_MAX_LENGTH = "{\"payload\":\"Lorem ipsum dolor sit amet," +
                " consectetuer adipiscing elit. Aenean commodo ligula eget dolor. " +
                "Aenean massa. Cum sociis natoque penatibus et magnis dis parturient.A\"}";
        static final String INVALID_PAYLOAD_SEND_TEXT_BELOW_MIN_LENGTH = "{\"payload\":\"\"}";
    }

    static final class ValidEmotionMessagePayload {
        static final String VALID_PAYLOAD_SEND_EMOTION = "{\"payload\":\"a%^*%aa\"}";
        static final String VALID_PAYLOAD_SEND_EMOTION_MAX_LENGTH = "{\"payload\":\"a(*&)aaaaa\"}";
        static final String VALID_PAYLOAD_SEND_EMOTION_MIN_LENGTH = "{\"payload\":\"^&\"}";
    }

    static final class InvalidEmotionMessagePayload {
        static final String INVALID_PAYLOAD_SEND_EMOTION_WITH_NUMBERS = "{\"payload\":\"aa841\"}";
        static final String INVALID_PAYLOAD_SEND_EMOTION_OVER_MAX_LENGTH = "{\"payload\":\"aa*^$%^&aaaaaa\"}";
        static final String INVALID_PAYLOAD_SEND_EMOTION_BELOW_MIN_LENGTH = "{\"payload\":\"*\"}";
    }

    static final class ValidGeneralCaseMessagePayload {
        static final String VALID_PAYLOAD_MORE_FIELDS_THAN_EXPECTED = "{\"payload\":\"valid\",\"type\":\"send_image\"}";
    }

    static final class InvalidGeneralCaseMessagePayload {
        static final String INVALID_PAYLOAD_NULL_VALUE = "{\"payload\":null}";
        static final String INVALID_PAYLOAD_EMPTY_BODY = "{}";
    }

    private ValidationConstantsPayload() {
    }
}

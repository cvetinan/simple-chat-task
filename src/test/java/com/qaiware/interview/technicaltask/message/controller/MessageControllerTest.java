package com.qaiware.interview.technicaltask.message.controller;

import com.qaiware.interview.technicaltask.message.SimpleChatTaskTestConfiguration;
import com.qaiware.interview.technicaltask.message.service.MessageRequestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.qaiware.interview.technicaltask.message.controller.ValidationConstantsPayload.InvalidEmotionMessagePayload.*;
import static com.qaiware.interview.technicaltask.message.controller.ValidationConstantsPayload.InvalidGeneralCaseMessagePayload.INVALID_PAYLOAD_EMPTY_BODY;
import static com.qaiware.interview.technicaltask.message.controller.ValidationConstantsPayload.InvalidGeneralCaseMessagePayload.INVALID_PAYLOAD_NULL_VALUE;
import static com.qaiware.interview.technicaltask.message.controller.ValidationConstantsPayload.InvalidTextMessagePayload.INVALID_PAYLOAD_SEND_TEXT_ABOVE_MAX_LENGTH;
import static com.qaiware.interview.technicaltask.message.controller.ValidationConstantsPayload.InvalidTextMessagePayload.INVALID_PAYLOAD_SEND_TEXT_BELOW_MIN_LENGTH;
import static com.qaiware.interview.technicaltask.message.controller.ValidationConstantsPayload.ValidEmotionMessagePayload.*;
import static com.qaiware.interview.technicaltask.message.controller.ValidationConstantsPayload.ValidGeneralCaseMessagePayload.VALID_PAYLOAD_MORE_FIELDS_THAN_EXPECTED;
import static com.qaiware.interview.technicaltask.message.controller.ValidationConstantsPayload.ValidTextMessagePayload.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {SimpleChatTaskTestConfiguration.class})
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class MessageControllerTest {
    private static final String SEND_TEXT_TYPE = "send_text";
    private static final String SEND_EMOTION_TYPE = "send_emotion";
    private static final String SEND_MESSAGE_INVALID_TYPE = "invalid_type";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MessageRequestService messageRequestService;

    @ParameterizedTest
    @ValueSource(strings = {
            VALID_PAYLOAD_SEND_TEXT,
            VALID_PAYLOAD_SEND_TEXT_MIN_LENGTH,
            VALID_PAYLOAD_SEND_TEXT_MAX_LENGTH,
            VALID_PAYLOAD_MORE_FIELDS_THAN_EXPECTED
    })
    void testSendTextValidPayloadShouldReturnCreated(String payload) throws Exception {
        ResultActions resultActions = sendRequest(SEND_TEXT_TYPE, payload);
        resultActions.andExpect(status().isCreated()).andExpect(jsonPath("$").doesNotExist());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            INVALID_PAYLOAD_SEND_TEXT_BELOW_MIN_LENGTH,
            INVALID_PAYLOAD_SEND_TEXT_ABOVE_MAX_LENGTH,
            INVALID_PAYLOAD_EMPTY_BODY,
            INVALID_PAYLOAD_NULL_VALUE
    })
    void testSendTextInvalidPayloadShouldReturnPreconditionFailed(String payload) throws Exception {
        ResultActions resultActions = sendRequest(SEND_TEXT_TYPE, payload);
        resultActions.andExpect(status().isPreconditionFailed()).andExpect(jsonPath("$").doesNotExist());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            VALID_PAYLOAD_SEND_EMOTION,
            VALID_PAYLOAD_SEND_EMOTION_MIN_LENGTH,
            VALID_PAYLOAD_SEND_EMOTION_MAX_LENGTH,
            VALID_PAYLOAD_MORE_FIELDS_THAN_EXPECTED
    })
    void testSendEmotionValidPayloadShouldReturnCreated(String payload) throws Exception {
        ResultActions resultActions = sendRequest(SEND_EMOTION_TYPE, payload);
        resultActions.andExpect(status().isCreated()).andExpect(jsonPath("$").doesNotExist());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            INVALID_PAYLOAD_SEND_EMOTION_WITH_NUMBERS,
            INVALID_PAYLOAD_SEND_EMOTION_BELOW_MIN_LENGTH,
            INVALID_PAYLOAD_SEND_EMOTION_OVER_MAX_LENGTH,
            INVALID_PAYLOAD_EMPTY_BODY,
            INVALID_PAYLOAD_NULL_VALUE})
    void testSendEmotionInvalidPayloadShouldReturnPreconditionFailed(String payload) throws Exception {
        ResultActions resultActions = sendRequest(SEND_EMOTION_TYPE, payload);
        resultActions.andExpect(status().isPreconditionFailed()).andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void testSendMessageWithInvalidRequestBody() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/messages/{type}", SEND_EMOTION_TYPE)
                        .content("<payload>Test</payload>")
                        .contentType(MediaType.TEXT_XML_VALUE)
                        .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isUnsupportedMediaType());
    }

    @Test
    void testSendMessageWithInvalidTypeValidRequestBody() throws Exception {
        ResultActions resultActions = mockMvc.perform(
                post("/messages/{type}", SEND_MESSAGE_INVALID_TYPE)
                        .content(VALID_PAYLOAD_SEND_TEXT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isPreconditionFailed());
    }

    /**
     * Helper method to remove repetitions in code
     * @param type - message type
     * @param payload - message body
     * @return ResultActions to verify
     * @throws Exception
     */
    private ResultActions sendRequest(String type, String payload) throws Exception {
        return mockMvc.perform(
                post("/messages/{type}", type)
                        .content(payload)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );
    }
}
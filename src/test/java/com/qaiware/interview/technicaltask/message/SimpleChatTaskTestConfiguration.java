package com.qaiware.interview.technicaltask.message;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;
import javax.validation.Validator;
@TestConfiguration
public class SimpleChatTaskTestConfiguration {

    @Bean
    public Validator getValidator() {
        try (var validatorFactory = Validation.buildDefaultValidatorFactory()) {
            return validatorFactory.getValidator();
        }
    }
}

package com.qaiware.interview.technicaltask.message.controller;

import com.qaiware.interview.technicaltask.constant.URLMappings;
import com.qaiware.interview.technicaltask.message.model.dto.MessageRequestBindingModel;
import com.qaiware.interview.technicaltask.message.model.dto.validationgroup.enumeration.MessageValidationGroup;
import com.qaiware.interview.technicaltask.message.service.MessageRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validator;

@RestController
@RequestMapping(URLMappings.Message.BASE_PATH)
public class MessageController {

    private final MessageRequestService messageRequestService;
    private final Validator validator;

    @Autowired
    public MessageController(MessageRequestService messageRequestService,
                             Validator validator) {
        this.messageRequestService = messageRequestService;
        this.validator = validator;
    }

    @PostMapping(value = URLMappings.Message.TYPE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendMessage(@PathVariable("type") String type,
                                         @RequestBody MessageRequestBindingModel messageRequestBindingModel) {

        final var constraintViolations = this.validator.validate(
                messageRequestBindingModel,
                MessageValidationGroup
                        .valueOf(type.toUpperCase())
                        .getValidationGroup());

        if (!constraintViolations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }

        messageRequestBindingModel.setType(type);

        this.messageRequestService.create(messageRequestBindingModel);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

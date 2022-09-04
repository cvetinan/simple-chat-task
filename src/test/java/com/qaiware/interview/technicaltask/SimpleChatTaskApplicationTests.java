package com.qaiware.interview.technicaltask;

import com.qaiware.interview.technicaltask.message.controller.MessageController;
import com.qaiware.interview.technicaltask.message.model.repository.MessageRequestRepository;
import com.qaiware.interview.technicaltask.message.service.MessageRequestService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpleChatTaskApplicationTests {


    @Test
    public void contextLoads(ApplicationContext context) throws Exception {
        assertThat(context.getBean(MessageController.class)).isNotNull();
        assertThat(context.getBean(MessageRequestService.class)).isNotNull();
        assertThat(context.getBean(Validator.class)).isNotNull();
        assertThat(context.getBean(MessageRequestRepository.class)).isNotNull();
    }

}

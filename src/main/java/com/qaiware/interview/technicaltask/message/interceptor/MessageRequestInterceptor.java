package com.qaiware.interview.technicaltask.message.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

import static com.qaiware.interview.technicaltask.constant.ValidationConstants.Message.MESSAGE_TYPE_PATH_PATTERN;

@Component
public class MessageRequestInterceptor implements HandlerInterceptor {
    private static final Pattern MESSAGE_TYPE_PATTERN = Pattern.compile(MESSAGE_TYPE_PATH_PATTERN, Pattern.CASE_INSENSITIVE);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final var requestURI = request.getRequestURI();
        final var hasMatch = MESSAGE_TYPE_PATTERN.matcher(requestURI).find();
        if (!hasMatch) {
            response.setStatus(HttpStatus.PRECONDITION_FAILED.value());
        }
        return hasMatch;
    }
}

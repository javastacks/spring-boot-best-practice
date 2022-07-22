package cn.javastack.springboot.web.handler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<?> handleException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>("global exception", HttpStatus.SERVICE_UNAVAILABLE);
    }

}
package cn.javastack.springboot.web.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

/**
 * 微信公众号：Java技术栈
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleException(HttpServletRequest request, Throwable ex) {
        log.error("global exception:", ex);
        return new ResponseEntity<>("global exception", HttpStatus.OK);
    }

    /**
     * 处理参数校验异常（在方法参数上使用了 @Validated 修饰类）
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("参数校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return new ResponseEntity(msg, HttpStatus.OK);
    }


    /**
     * 处理参数校验异常（在方法参数上直接使用了 @Size 等约束）
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        StringBuilder sb = new StringBuilder("参数校验失败:");
        for (ConstraintViolation constraintViolation : constraintViolations) {
            sb.append(constraintViolation.getPropertyPath()).append("：").append(constraintViolation.getMessage()).append(", ");
        }
        String msg = sb.toString();
        return new ResponseEntity(msg, HttpStatus.OK);
    }

}
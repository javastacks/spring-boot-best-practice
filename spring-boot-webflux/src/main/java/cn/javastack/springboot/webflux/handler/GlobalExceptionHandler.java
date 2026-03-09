package cn.javastack.springboot.webflux.handler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 全局异常处理器
 * 微信公众号：Java技术栈
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected Mono<ResponseEntity<Object>> handleWebExchangeBindException(WebExchangeBindException ex,
                                                                          HttpHeaders headers,
                                                                          HttpStatusCode status,
                                                                          ServerWebExchange exchange) {
        log.error("WebExchangeBindException:", ex);
        return badRequestResponse(buildBindingErrorMessage(ex.getFieldErrors()));
    }

    /**
     * 处理参数校验异常（在方法参数上直接使用了 @Size 等约束）
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseEntity<Object>> handleConstraintViolationException(ConstraintViolationException ex) {
        log.error("ConstraintViolationException:", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : violations) {
            errors.add(violation.getPropertyPath() + "：" + violation.getMessage());
        }
        return badRequestResponse(buildValidationErrorMessage(errors));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<Object>> handleException(Exception ex) {
        log.error("global exception:", ex);
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("global exception"));
    }

    private Mono<ResponseEntity<Object>> badRequestResponse(String message) {
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message));
    }

    private String buildBindingErrorMessage(List<FieldError> fieldErrors) {
        return buildValidationErrorMessage(toFieldErrors(fieldErrors));
    }

    private List<String> toFieldErrors(List<FieldError> fieldErrors) {
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            errors.add(fieldError.getField() + "：" + fieldError.getDefaultMessage());
        }
        return errors;
    }

    private String buildValidationErrorMessage(List<String> errors) {
        if (errors.isEmpty()) {
            return "参数校验失败";
        }
        return "参数校验失败:" + String.join(", ", errors);
    }

}

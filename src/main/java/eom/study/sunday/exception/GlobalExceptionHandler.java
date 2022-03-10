package eom.study.sunday.exception;

import eom.study.sunday.response.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NoInputDataException.class})
    protected ResponseEntity<ErrorResult> handleNoInputDataException(final NoInputDataException e) {
        System.out.println("NoInputDataException Handler");
        final ErrorResult errorResult = ErrorResult.of(e.getErrorCode(), e.getBindingResult());

        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }
}

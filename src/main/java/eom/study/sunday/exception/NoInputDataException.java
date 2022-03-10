package eom.study.sunday.exception;

import eom.study.sunday.response.ErrorCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoInputDataException extends RuntimeException {
    private ErrorCode errorCode;
    // MethodArgumentNotValidException 동시 상속 불가
    private BindingResult bindingResult;

    public NoInputDataException(ErrorCode errorCode, BindingResult bindingResult) {
        this.errorCode = errorCode;
        this.bindingResult = bindingResult;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}

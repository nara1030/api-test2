package eom.study.sunday.exception;

import eom.study.sunday.response.ErrorCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoInputDataException extends RuntimeException {
    private ErrorCode errorCode;
    // MethodArgumentNotValidException 동시 상속 불가
    // RuntimeException을 상속하면서 BindingResult를 갖는다는 게 좀 모순인 것 같다..
    private BindingResult bindingResult;
    private String url;

    public NoInputDataException(ErrorCode errorCode, BindingResult bindingResult) {
        this.errorCode = errorCode;
        this.bindingResult = bindingResult;
        this.url = null;
    }

    // HttpStatus = 404
    public NoInputDataException(ErrorCode errorCode, String url) {
        this.errorCode = errorCode;
        this.url = url;
        this.bindingResult = null;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public String getUrl() {
        return url;
    }
}

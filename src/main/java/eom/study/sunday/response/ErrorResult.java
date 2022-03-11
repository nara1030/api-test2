package eom.study.sunday.response;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ErrorResult {
    private int httpStatus;
    private String code;
    private String message;
    // Error는 발생 시점이 아닌, Binding 개념이기 때문에 복수 개 존재
    private List<FieldError> errors;

    private ErrorResult(final ErrorCode errorCode, final List<FieldError> errors) {
        this.httpStatus = errorCode.getHttpStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.errors = errors;
    }

    private ErrorResult(final ErrorCode errorCode) {
        this.httpStatus = errorCode.getHttpStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.errors = new ArrayList<>();
    }

    public static ErrorResult of(final ErrorCode errorCode) {
        return new ErrorResult(errorCode);
    }

    public static ErrorResult of(final ErrorCode errorCode, final List<FieldError> errors) {
        return new ErrorResult(errorCode, errors);
    }

    public static ErrorResult of(final ErrorCode errorCode, final BindingResult bindingResult) {
        return new ErrorResult(errorCode, FieldError.of(bindingResult));
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        private FieldError(final String field, final String value, final String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        // 비컨트롤러단의 경우 BindingResult 미존재
        public static List<FieldError> of(final String field, final String value, final String reason) {
            List<FieldError> fieldErrors = new ArrayList<>();
            fieldErrors.add(new FieldError(field, value, reason));
            return fieldErrors;
        }

        // 컨트롤러단
        private static List<FieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }

        public String getField() {
            return field;
        }

        public String getValue() {
            return value;
        }

        public String getReason() {
            return reason;
        }
    }
}

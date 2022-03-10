package eom.study.sunday.response;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    // Client Error
    NOT_FOUND_URL(404, "C001", "해당 URL이 존재하지 않습니다."),
    INVALID_INPUT_VALUE(400, "C002", "유효하지 않은 입력값입니다.");

    private ErrorCode(int httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
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

    private final int httpStatus;
    private final String code;
    private final String message;
}

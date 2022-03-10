package eom.study.sunday.response;

/**
 * ErrorResult처럼 따로 응답 Response를 상속받게 하여 통일성 있게 하면 좋을듯
 */
public class Result {
    private String share;
    private String remain;

    private Result(String share, String remain) {
        this.share = share;
        this.remain = remain;
    }

    public String getShare() {
        return share;
    }

    public String getRemain() {
        return remain;
    }

    // 여기서 매개변수로 받는 unit은 RequestVo의 share와 동일
    // static을 사용하는 게 맞나..? ResponseEntity 생각해보면..
    public static Result getResult(String data, Integer unit) {
        int len = data.length();
        if (unit >= len) {
            return new Result(data, "");
        }

        String share = data.substring(0, len - (len % unit));
        String remain = data.substring(len - (len % unit), len);
        return new Result(share, remain);
    }
}

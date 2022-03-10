package eom.study.sunday.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RequestVo {
    @NotNull(message = "URL은 필수 입력값입니다.")
    private String url;
    // ExposureType과의 명시적인 연관
    @NotNull(message = "노출유형은 필수 입력값입니다.")
    private String exposureType;
    @NotNull(message = "출력묶음 단위는 필수 입력값입니다.")
    @Min(value = 1, message = "출력묶음 단위는 양수여야 합니다.")
    private Integer share;

    // Null 체크 및 메소드 위치 고민
    public String getUrlData() {
        String data = null;
        for (ExposureTypeValue exposureTypeValue : ExposureTypeValue.values()) {
            if (exposureType.equals(exposureTypeValue.getType())) {
                data = exposureTypeValue.parseUrlData(url);
            }
        }

        return data;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setExposureType(String exposureType) {
        this.exposureType = exposureType;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getShare() {
        return share;
    }
}

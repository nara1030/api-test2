package eom.study.sunday.util;

import java.util.HashMap;
import java.util.Map;

public class CustomFilter {
    /**
     * 문자열 중 영어, 숫자만 필터링 후 반환
     *
     * @param
     * @return
     * @exception
     */
    public static Map filterData(String data) {
        Map<String, String> result = new HashMap<>();
        result.put("number", data.replaceAll(DataType.NUMBER.regularExpression, ""));
        result.put("alphabet", data.replaceAll(DataType.ALPHABET.regularExpression, ""));

        return result;
    }

    enum DataType {
        NUMBER("N", "[^0-9]"),
        ALPHABET("A", "[^a-zA-Z]");

        private DataType(String dataType, String regularExpression) {
            this.dataType = dataType;
            this.regularExpression = regularExpression;
        }

        private String dataType;
        private String regularExpression;
    }
}

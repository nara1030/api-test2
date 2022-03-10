package eom.study.sunday.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomSorter {
    /**
     * 정렬 규칙에 맞춰 문자열 정렬(확장성 고려 리팩토링 필요...)
     *
     * @param
     * @return
     * @exception
     */
    public static Map sortData(Map map) {
        Map<String, String> result = new HashMap<>();
        String numbers = (String) map.get("number");
        String alphabets = (String) map.get("alphabet");

        // 숫자 정렬
        int[] numberArray = new int[numbers.length()];
        for (int i = 0, len = numbers.length(); i < len; i++) {
            numberArray[i] = Integer.parseInt(numbers.substring(i, i + 1));
        }
        Arrays.sort(numberArray);
        result.put("number", Arrays.stream(numberArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));

        // 알파벳 정렬
        String[] alphabetArray = new String[alphabets.length()];
        for (int i = 0, len = alphabets.length(); i < len; i++) {
            alphabetArray[i] = alphabets.substring(i, i + 1);
        }
        Arrays.sort(alphabetArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                if(o1.equalsIgnoreCase(o2)) {
//                    if(o1.toUpperCase().equals(o1)){
//                        return -1;
//                    } else {
//                        return 1;
//                    }
//                } else {
//                    return o1.compareToIgnoreCase(o2);
//                }
                int res = o1.compareToIgnoreCase(o2);
                return (res == 0) ? o1.compareTo(o2) : res;
            }
        });
        result.put("alphabet", String.join("", alphabetArray));

        return result;
    }
}

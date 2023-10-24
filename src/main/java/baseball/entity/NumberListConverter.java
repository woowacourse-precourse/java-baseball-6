package baseball.entity;

import java.util.List;

public class NumberListConverter {
    // List<Integer>의 원소들을 합쳐 String으로 변환해주는 함수
    public static String integerListToString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer i : list) {
            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }
}

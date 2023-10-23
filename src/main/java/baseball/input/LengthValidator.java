package baseball.input;

import java.util.stream.IntStream;

public class LengthValidator {
    public static boolean isValid(String input) {
        // 입력 문자열에서 서로 다른 문자의 개수를 계산합니다.
        int uniqueNumbers = Math.toIntExact(input.chars()  // 스트림 생성
                .distinct()  // 중복 제거
                .count()); // 중복이 제거된 문자의 개수를 계산)

        // 서로 다른 문자의 개수가 입력 문자열의 길이와 같은지 확인
        return IntStream.of(input.length(), uniqueNumbers)
                .allMatch(x -> x == 3);
    }
}

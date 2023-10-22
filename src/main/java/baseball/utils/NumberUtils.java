package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {

    /**
     * int -> list<integer> 변환 메서드
     */
    public static List<Integer> getDigit(int number) {

        List<Integer> digits = new ArrayList<>();

        int digit1 = number / 100;
        int digit2 = (number % 100) / 10;
        int digit3 = number % 10;

        digits.add(digit1);
        digits.add(digit2);
        digits.add(digit3);

        return digits;
    }

    /**
     * string -> int 변환 메서드
     */
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 정수를 입력해주세요.");
        }
    }
}

package baseball;

import java.util.Arrays;
import java.util.List;

public class NumberConverter {
    public static List<Integer> from(String strNumber) {
        List<Integer> number = convert(strNumber);
        validate(number);
        return number;
    }

    private static List<Integer> convert(String number) {
        try {
            return Arrays.stream(number.split(""))
                    .map(Integer::parseInt)
                    .filter(n -> n != 0)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 입력해주세요");
        }
    }

    private static void validate(List<Integer> number) {
        isThreeNums(number);
        isUnduplicated(number);
    }

    private static void isThreeNums(List<Integer> number) {
        if (number.size() != 3) {
            throw new IllegalArgumentException("1부터 9까지 3개의 숫자를 입력해주세요");
        }
    }

    private static void isUnduplicated(List<Integer> number) {
        if (number.size() != number.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 숫자들을 입력해주세요");
        }
    }
}

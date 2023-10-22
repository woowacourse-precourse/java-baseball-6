package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Utils {
    public static List<Integer> generateComputerRandomNumber(int length) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        List<Integer> computerRandomNumber = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }
        return computerRandomNumber;
    }

    public static void validateStringNaturalNumberLengthDuplicate(String input) {
        validateStringNaturalNumber(input);
        validateStringLength(input, 3);
        validateStringDuplicate(input);
    }

    public static void validateStringNaturalNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("1 ~ 9사이의 자연수를 입력해주세요.");
            }
        }
    }

    public static void validateStringLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("정해진 길이의 문자열을 입력해주세요.");
        }
    }

    public static void validateStringDuplicate(String input) {
        Set<String> set = new HashSet<>(Arrays.stream(input.split("")).toList());
        if (set.size() != input.length()) {
            throw new IllegalArgumentException("중복되지 않은 문자열을 입력해주세요.");
        }
    }
}

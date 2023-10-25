package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {
    public static List<Integer> generateRandomNumber(int length) {
        List<Integer> computerRandomNumber = new ArrayList<>();
        while (computerRandomNumber.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }
        return computerRandomNumber;
    }

    public static void validateStringOneOrTwo(String input) {
        if (input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }

    public static void validateStringThreeDifferentDigits(String input) {
        validateStringLength(input, 3);
        validateStringNaturalNumbers(input);
        validateAllDifferentCharacters(input);
    }

    public static void validateStringLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
    }

    public static void validateStringNaturalNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
        }
    }

    public static void validateAllDifferentCharacters(String input) {
        List<Character> list = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        HashSet<Character> set = new HashSet<>(list);
        if (set.size() != input.length()) {
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
    }

    public static List<Integer> stringToIntegerList(String input) {
        validateStringNaturalNumbers(input);
        List<Integer> integerList = new ArrayList<>();
        for (String s : input.split("")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }
}
package baseball.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputUtil {

    public static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> integerList = new ArrayList<>();
        for(String s : input.split("")) {
            integerList.add(Integer.parseInt(s));
        }
        return integerList;
    }

    public static void validateThreeDifferentNatureNumber(String input) {
        validateLength(input);
        validateNaturalNumber(input);
        validateAllDifferentCharacters(input);
    }

    public static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 애플리케이션을 종료합니다.");
        }
    }

    public static void validateNaturalNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException("잘못된 값을 입력했습니다. 애플리케이션을 종료합니다.");
            }
        }
    }

    public static void validateAllDifferentCharacters(String input) {
        Set<Character> set = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (isContains(set, c)) {
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
            set.add(c);
        }
    }

    private static boolean isContains(Set<Character> set, char c) {
        return set.contains(c);
    }
}

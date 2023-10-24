package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberUtils {

    public static void validateInputUserNumber(String input) {
        if (input.length()!=3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다.");
        } else if (!input.matches("^[1-9]+$")) {
            throw new IllegalArgumentException("1-9 사이의 숫자가 아닙니다.");
        } else if (checkDuplicate(input)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야합니다.");
        } else if (input==null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public static void validateInputNewGameNumber(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("1과 2 중 입력해야합니다.");
        }
    }

    public static boolean checkDuplicate(String input) {
        Set<Character> characterSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (characterSet.contains(c)) {
                return true;
            }
            characterSet.add(c);
        }

        return false;
    }

    private static List<Integer> toIntegerList(String input) {
        List<Integer> userNumber = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                userNumber.add(Integer.parseInt(Character.toString(c)));
            }
        }

        return userNumber;
    }

    public static List<Integer> getUserNumber() {
        String input = Console.readLine();
        validateInputUserNumber(input);

        return toIntegerList(input);
    }

}

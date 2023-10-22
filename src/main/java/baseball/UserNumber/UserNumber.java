package baseball.userNumber;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    public static void validateInputNumber(String input) {
        if (input.length() != 3 || !input.matches("\\d+")) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
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
        validateInputNumber(input);

        return toIntegerList(input);
    }

}

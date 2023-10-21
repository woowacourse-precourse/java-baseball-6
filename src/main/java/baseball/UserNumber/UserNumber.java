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
        List<Integer> randomNumber = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                randomNumber.add(Integer.valueOf(c));
            }
        }

        return randomNumber;
    }

    public static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateInputNumber(input);

        return toIntegerList(input);
    }

}

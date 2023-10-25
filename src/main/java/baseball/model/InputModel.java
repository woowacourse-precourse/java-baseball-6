package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputModel {
    private static String guess;
    private static List<Integer> guessToList;

    public static void inputThreeNumber() {
        guess = Console.readLine();
    }

    public static void isInputThreeNumber() {

        if (guess.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요");
        }
        for (int i = 0; i < 3; i++) {
            boolean isNum = Character.isDigit(guess.charAt(i));
            if (!isNum) {
                throw new IllegalArgumentException("문자가 아닌 숫자를 입력해주세요");
            }
        }
    }

    public static void guessToIntegerList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            int digit = Character.getNumericValue(c);
            list.add(digit);
        }

        if (list.get(0).equals(list.get(1)) || list.get(1).equals(list.get(2)) || list.get(2).equals(list.get(0))) {
            throw new IllegalArgumentException("3개의 숫자는 달라야 합니다");
        }
        guessToList = list;
    }

    public static List<Integer> getGuessToList() {
        return guessToList;
    }
}

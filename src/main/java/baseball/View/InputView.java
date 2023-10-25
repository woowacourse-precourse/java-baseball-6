package baseball.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputView {
    private boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        Set<Character> digits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (digit < '1' || digit > '9') {
                return false;
            }
            if (digits.contains(digit)) {
                return false;
            }
            digits.add(digit);
        }
        return true;
    }

    public int[] setUserInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Character.getNumericValue(input.charAt(i));
        }
        return numbers;
    }
    public static String setReGameNum(){우
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Application {
    public String setRandomDistinctNumbers() {
        int number = Randoms.pickNumberInRange(1, 9);
        return String.valueOf(number);
    }

    public String startGame() {
        return "숫자 야구 게임을 시작합니다.";
    }

    public void confirmGameEnd() {}
    public void compareDigitsNumbers() {}
    public void countCommonNumbers() {}
    public void showBaseballOutcome() {}
    public void checkInputValidation(String input) {
        if (input == null || input.isEmpty() || !input.matches("\\d{3}")) {
            throw new IllegalArgumentException();
        }
        char[] digits = input.toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
    public void checkExitChoiceValidation(String input) {
        if(input != "1" || input != "2") {
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {

    }
}

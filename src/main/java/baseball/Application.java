package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    public String setRandomDistinctNumbers() {
        int number = Randoms.pickNumberInRange(1, 9);
        return String.valueOf(number);
    }

    public String startGame() {
        return "숫자 야구 게임을 시작합니다.";
    }
    public int compareDigitsNumbers(String answer, String input) {
        int strikeCnt = 0;
        answer = setRandomDistinctNumbers();
        input = Console.readLine();
        checkInputValidation(input);

        List<String> answerList = new ArrayList<>();
        List<String> inputList = new ArrayList<>();

        for(int i = 0; i<3; i++){
            answerList.add(Arrays.toString(answer.split("")));
            inputList.add(Arrays.toString(input.split("")));
        }

        for(int i = 0; i<3; i++) {
            if (answerList.get(i).equals(inputList.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }
    public void countCommonNumbers() {}
    public void showBaseballOutcome() {}
    public void confirmGameEnd() {}
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

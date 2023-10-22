package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final int randomLength = 3;
    private List<Integer> randomInt;
    private List<Integer> userInput;
    private int strike;
    private int ball;
    private boolean isSolved;

    public Game() {
        setRandomInt();
    }

    private void setRandomInt() {
        randomInt = new ArrayList<>();
        while (randomInt.size() < randomLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomInt.contains(randomNumber)) {
                randomInt.add(randomNumber);
            }
        }
    }

    public void getUserInput() {
        userInput = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateUserInput(input);
        for (int j = 0; j < input.length(); j++) {
            userInput.add(input.charAt(j) - '0');
        }
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void printResult() {
        JudgeInput();
        String result = "";
        if (ball > 0 && strike > 0) {
            result = ball + "볼 " + strike + "스트라이크";
        }
        else if (ball == 0 && strike == 0) {
            result = "낫싱";
        }
        else {
            if (ball > 0) {
                result = ball + "볼";
            }
            else {
                result = strike + "스트라이크";
            }
        }
        System.out.println(result);
    }

    private void JudgeInput() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < randomLength; i++) {
            if (randomInt.get(i).equals(userInput.get(i))) {
                strike++;
            }
            else if (randomInt.contains(userInput.get(i))) {
                ball++;
            }
        }
        if (strike == randomLength)
            isSolved = true;
    }

    private void validateUserInput(String input) {
        if (input.length() != randomLength) {
            throw new IllegalArgumentException("input has to be 3 digits.");
        }
        for (int i = 0; i < input.length(); i++) {
            if ('1' > input.charAt(i) || input.charAt(i) > '9') {
                throw new IllegalArgumentException("input has to be formed with digits between 1 to 9.");
            }
            if (input.lastIndexOf(input.charAt(i)) != i) {
                throw new IllegalArgumentException("input has to be formed with different digits.");
            }
        }
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class BaseballGame {
    public static final int gameNumberDigits = 3;
    private static final Output output = new Output();
    private static final Input input = new Input();
    private final ArrayList<Integer> targetNumbers = new ArrayList<>();
    private int strike;
    private int ball;

    public void playBaseballGame() {
        setTargetNumbers();
        while(strike!= gameNumberDigits) {
            countStrikeAndBall(input.inputUserNumbers());
        }
        restartGame();
    }

    private void setTargetNumbers() {
        while(targetNumbers.size() < gameNumberDigits) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
            }
        }
    }

    private void countStrikeAndBall(ArrayList<Integer> userNumbers) {
        resetStrikeAndBall();
        countStrike(userNumbers);
        countBall(userNumbers);
        output.printStrikeBallMessage(strike, ball);
    }

    private void resetStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private void countStrike(ArrayList<Integer> userNumbers) {
        for(int numbersIndex = 0; numbersIndex< gameNumberDigits; numbersIndex++) {
            if(userNumbers.get(numbersIndex).equals(targetNumbers.get(numbersIndex))) {
                strike++;
            }
        }
    }

    private void countBall(ArrayList<Integer> userNumbers) {
        for(int numbersIndex = 0; numbersIndex< gameNumberDigits; numbersIndex++) {
            if(targetNumbers.contains(userNumbers.get(numbersIndex)) &
                    !targetNumbers.get(numbersIndex).equals(userNumbers.get(numbersIndex))) {
                ball++;
            }
        }
    }

    private void restartGame() {
        resetGameElementForRestartGame();
        output.printSelectRestartMessage();
        String restartOption = inputRestartOption();
        if(restartOption.equals("1")) {
            playBaseballGame();
        }
    }

    private void resetGameElementForRestartGame() {
        targetNumbers.clear();
        resetStrikeAndBall();
    }

    private String inputRestartOption() {
        return Console.readLine();
    }
}

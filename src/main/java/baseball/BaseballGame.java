package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class BaseballGame {
    private static final Output output = new Output();
    private static final Input input = new Input();
    private final ArrayList<Integer> targetNumbers = new ArrayList<>();
    private int strike;
    private int ball;

    public void playBaseballGame() {
        setTargetNumbers();
        while(strike!=3) {
            countStrikeAndBall(input.inputUserNumbers());
        }
        restartGame();
    }

    private void setTargetNumbers() {
        while(targetNumbers.size() < 3) {
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
        for(int numbersIndex=0; numbersIndex<3; numbersIndex++) {
            if(userNumbers.get(numbersIndex).equals(targetNumbers.get(numbersIndex))) {
                strike++;
            }
        }
    }

    private void countBall(ArrayList<Integer> userNumbers) {
        for(int numbersIndex=0; numbersIndex<3; numbersIndex++) {
            if(targetNumbers.contains(userNumbers.get(numbersIndex)) &
                    !targetNumbers.get(numbersIndex).equals(userNumbers.get(numbersIndex))) {
                ball++;
            }
        }
    }

    private void restartGame() {
        resetTargetNumbers();
        output.printSelectRestartMessage();
        String restartOption = inputRestartOption();
        if(restartOption.equals("1")) {
            playBaseballGame();
        }
    }

    private void resetTargetNumbers() {
        targetNumbers.clear();
    }

    private String inputRestartOption() {
        return Console.readLine();
    }
}

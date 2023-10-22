package baseball;

import static baseball.BaseballGameView.*;
import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseballGame {
    List<Integer> computerNumber;
    private final Validator validator;

    NumberBaseballGame() {
        this.validator = new Validator();
    }

    public void start() {
        showStartMessage();
        boolean gameContinuation = true;
        while (gameContinuation) {
            computerNumber = generateRandomNumbers();
            runGameLoop();
            gameContinuation = getContinueInput();
        }
    }

    private void runGameLoop() {
        boolean userWin = false;
        while (!userWin) {
            List<Integer> userNumber = userNumberInput();
            int strike = countStrike(userNumber, computerNumber);
            int ball = countBall(userNumber, computerNumber) - strike;
            printLoopResult(ball, strike);
            if (isUserWin(strike)) {
                showWinMessage();
                userWin = true;
            }
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> generatedNumbers = new ArrayList<>(MAX_NUMBER_LENGTH);
        while (generatedNumbers.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }
        return generatedNumbers;
    }

    private List<Integer> userNumberInput() {
        showNumberInputMessage();
        String inputString = Console.readLine();
        validator.numberInput(inputString);

        return inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }


    boolean isUserWin(int strike) {
        return strike == MAX_NUMBER_LENGTH;
    }

    int countBall(List<Integer> userNumber, List<Integer> computerNumber) {
        int ball = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    int countStrike(List<Integer> userNumber, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private boolean getContinueInput() {
        showGameContinueInputMessage();
        String inputContinue = Console.readLine();
        validator.continueInput(inputContinue);
        return inputContinue.equals(CONTINUE);
    }
}

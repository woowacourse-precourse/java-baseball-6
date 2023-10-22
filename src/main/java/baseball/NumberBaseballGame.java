package baseball;

import static baseball.BaseballGameView.*;
import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class NumberBaseballGame {
    List<Integer> computerNumber;

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
        validateInput(inputString);

        return inputString.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    void validateInput(String inputString) throws IllegalArgumentException {
        if (!Pattern.matches(INPUT_REGEX, inputString) || !hasUniqueNumber(inputString)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT + inputString);
        }
    }

    private boolean hasUniqueNumber(String inputString) {
        Set<Character> set = new HashSet<>();
        for (char s : inputString.toCharArray()) {
            set.add(s);
        }
        return set.size() == MAX_NUMBER_LENGTH;
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
        validateContinueInput(inputContinue);
        return inputContinue.equals(CONTINUE);
    }

    void validateContinueInput(String inputContinue) throws IllegalArgumentException {
        if (!inputContinue.equals(CONTINUE) && !inputContinue.equals(Constants.STOP)) {
            throw new IllegalArgumentException(ERROR_INVALID_CONTINUE_INPUT);
        }
    }
}

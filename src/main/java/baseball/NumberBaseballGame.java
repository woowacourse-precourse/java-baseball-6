package baseball;

import static baseball.BaseballGameView.printLoopResult;
import static baseball.BaseballGameView.showGameContinueInputMessage;
import static baseball.BaseballGameView.showNumberInputMessage;
import static baseball.BaseballGameView.showStartMessage;
import static baseball.BaseballGameView.showWinMessage;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class NumberBaseballGame {
    List<Integer> computerNumber;
    private static final String INPUT_REGEX = "^[1-9]{3}$";
    private static final int MAX_NUMBER_LENGTH = 3;

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
            if (isUserWin(userNumber, computerNumber)) {
                showWinMessage();
                userWin = true;
            }
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> generatedNumbers = new ArrayList<>(MAX_NUMBER_LENGTH);
        while (generatedNumbers.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
        if (!Pattern.matches(INPUT_REGEX, inputString)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력입니다: " + inputString);
        }
    }

    boolean isUserWin(List<Integer> userNumber, List<Integer> computerNumber) {
        int ball = countBall(userNumber, computerNumber);
        int strike = countStrike(userNumber, computerNumber);
        ball -= strike;
        printLoopResult(ball, strike);
        return strike == MAX_NUMBER_LENGTH;
    }

    int countBall(List<Integer> user, List<Integer> computerNumber) {
        int ball = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computerNumber.contains(user.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    int countStrike(List<Integer> user, List<Integer> computerNumber) {
        int strike = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            if (computerNumber.get(i).equals(user.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private boolean getContinueInput() {
        showGameContinueInputMessage();
        String inputContinue = Console.readLine();
        validateContinueInput(inputContinue);
        return inputContinue.equals("1");
    }

    void validateContinueInput(String inputContinue) throws IllegalArgumentException {
        if (!inputContinue.equals("1") && !inputContinue.equals("2")) {
            throw new IllegalArgumentException("[ERROR] 1 또는 2 를 입력하세요.");
        }
    }
}

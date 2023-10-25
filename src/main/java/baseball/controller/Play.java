package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.Score;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Play {
    private static boolean playFlag = true;
    private static final int STRIKE_THREE = 3;
    private static final String USER_NUMBER_PATTERN = "^[1-9]{3}$";
    private final Score score;
    private final UserNumber userNumber;

    public Play() {
        this.score = new Score();
        this.userNumber = new UserNumber();
    }

    public void play(ComputerNumber computerNumber) {
        checkThreeStrike(score);
        while (playFlag) {
            score.countScore(checkUserNumberInput(), computerNumber.getComputerNumber());
            printResult(score);
            checkThreeStrike(score);
            score.resetScore();
        }
    }

    private void checkThreeStrike(Score score) {
        int strike = score.getStrike();
        if (strike == STRIKE_THREE) {
            playFlag = false;
            return;
        }
        playFlag = true;
    }

    private void printResult(Score score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (strike == 0 && ball == 0) {
            OutputView.nothing();
            return;
        }

        if (strike == 0) {
            OutputView.onlyBall(ball);
            return;
        }

        if (ball == 0) {
            OutputView.onlyStrike(strike);
            return;
        }

        if (strike > 0 && ball > 0) {
            OutputView.strikeAndBall(strike, ball);
            return;
        }
    }

    private List<Integer> checkUserNumberInput() {
        String input = InputView.userNumberInput();

        if (!checkNumberPattern(input)) {
            throw new IllegalArgumentException();
        }

        userNumber.newUserNumber(input);

        if (!checkDuplicateNumber(userNumber.getUserNumber())) {
            throw new IllegalArgumentException();
        }

        return userNumber.getUserNumber();
    }

    private boolean checkNumberPattern(String input) {
        return Pattern.matches(USER_NUMBER_PATTERN, input);
    }

    private boolean checkDuplicateNumber(List<Integer> userNumber) {
        Set<Integer> userNumberOfSet = new HashSet<>(userNumber);
        int sizeOfSet = userNumberOfSet.size();
        int sizeOfList = userNumber.size();

        return sizeOfList == sizeOfSet;
    }
}

package baseball.controller;

import baseball.model.CountStrikeAndBall;
import baseball.model.RandomNumberGenerator;
import baseball.model.UserNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    public void gameStart() {
        InputView.firstStart();
        do {
            OneGameStart();
        } while (isFinish());
    }

    private static void OneGameStart() {
        List<Integer> answerNumbers = generateRandomNumbers();
        while (true) {
            List<Integer> userNumbers = generateUserNumbers();
            CountStrikeAndBall countStrikeAndBall = new CountStrikeAndBall(answerNumbers, userNumbers);
            OutputView outputView = new OutputView(countStrikeAndBall);
            outputView.printBallAndStrike();
            if (outputView.strike == 3) {
                break;
            }
        }
    }

    private static List<Integer> generateRandomNumbers() {
        return RandomNumberGenerator.makeRandomNumber();
    }

    private static List<Integer> generateUserNumbers() {
        String userNumbersToString = InputView.startInput();
        return UserNumberGenerator.makeUserNumberToList(userNumbersToString);
    }

    private static boolean isFinish() {
        String restart = InputView.endInput();
        return restart.equals("1");
    }
}

package baseball.controller;

import baseball.model.CountStrikeAndBall;
import baseball.model.RandomNumberGenerator;
import baseball.model.UserNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    public void gameStart() {
        List<Integer> answerNumbers = generateRandomNumbers();
        do {
            List<Integer> userNumbers = generateUserNumbers();
            CountStrikeAndBall countStrikeAndBall = new CountStrikeAndBall(answerNumbers, userNumbers);
            OutputView outputView = new OutputView(countStrikeAndBall);
            outputView.printBallAndStrike();
            if (finishGame(outputView)) {
                break;
            }
        } while (true);
    }

    private static List<Integer> generateRandomNumbers() {
        return RandomNumberGenerator.makeRandomNumber();
    }

    private static List<Integer> generateUserNumbers() {
        String userNumbersToString = InputView.startInput();
        return UserNumberGenerator.makeUserNumberToList(userNumbersToString);
    }

    private static boolean finishGame(OutputView outputView) {
        return outputView.strike == 3;
    }


}

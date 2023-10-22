package baseball.controller;

import baseball.model.RandomNumberGenerator;
import baseball.model.UserNumberGenerator;
import baseball.view.InputView;
import java.util.List;

public class BaseballGame {
    public void gameStart() {
        List<Integer> answerNumbers = generateRandomNumbers();
        List<Integer> userNumbers = generateUserNumbers();
    }

    private static List<Integer> generateRandomNumbers() {
        return RandomNumberGenerator.makeRandomNumber();
    }

    private static List<Integer> generateUserNumbers() {
        String userNumbersToString = InputView.startInput();
        return UserNumberGenerator.makeUserNumberToList(userNumbersToString);
    }

}

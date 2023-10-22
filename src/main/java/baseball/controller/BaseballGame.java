package baseball.controller;

import baseball.model.RandomNumberGenerator;
import baseball.view.InputView;
import java.util.ArrayList;
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
        return convertStringtoList(userNumbersToString);
    }

    private static List<Integer> convertStringtoList(String str) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitStr = str.split("");
        for (String splitUserNumber : splitStr) {
            int parseInt = Integer.parseInt(splitUserNumber);
            numbers.add(parseInt);
        }
        return numbers;
    }
}

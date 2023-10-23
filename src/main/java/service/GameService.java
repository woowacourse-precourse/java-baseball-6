package service;

import java.util.List;

import static domain.NumberConstant.*;
import static service.NumberService.*;
import static service.PrintService.*;

public class GameService {
    public static void playOneGame() {
        List<Integer> answer = generateRandomNumber(NUMBER_SET_SIZE);
        List<Integer> input;

        do {
            printInputForm();
            input = readInputNumber(NUMBER_SET_SIZE);
        } while (!checkResult(answer, input, NUMBER_SET_SIZE, CORRECT_STRIKE_NUM));

        printCorrectAnswer();
    }

    private static boolean checkResult(List<Integer> answer, List<Integer> input, int size, int correctStrike) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < size; i++) {
            Integer num = input.get(i);

            if (answer.contains(num)) {
                if (i == answer.indexOf(num)) ++strike;
                else ++ball;
            }
        }

        printCheckResult(ball, strike);

        return strike == correctStrike;
    }

    public static boolean isRestart() {
        printRestartForm();

        return readRestartNumber() == 1;
    }
}

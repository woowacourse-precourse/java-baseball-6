package service;

import java.util.List;

import static domain.NumberConstant.CORRECT_STRIKE_NUM;
import static domain.NumberConstant.NUMBER_SET_SIZE;
import static service.NumberService.*;
import static service.PrintService.*;

public class GameService {
    public static void playOneGame() {
        List<Integer> answer = generateRandomNumber(NUMBER_SET_SIZE);
        List<Integer> input;

        do {
            printInput();
            input = readInputNumber(NUMBER_SET_SIZE);
        } while (!checkResult(answer, input, NUMBER_SET_SIZE, CORRECT_STRIKE_NUM));

        printCorrectAnswer();
    }

    private static boolean checkResult(List<Integer> answer, List<Integer> input, int size, int correct) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < size; i++) {
            Integer num = input.get(i);

            if (answer.contains(num)) {
                if (i == answer.indexOf(num)) ++strike;
                else ++ball;
            }
        }

        printAnswerCheckResult(ball, strike);

        return strike == correct;
    }

    public static boolean isRestart() {
        printRestart();

        return readRestartNumber() == 1;
    }
}

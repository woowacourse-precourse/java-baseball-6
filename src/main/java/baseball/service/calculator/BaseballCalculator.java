package baseball.service.calculator;

import baseball.domain.computer.ComputerNumber;
import baseball.dto.Result;

import java.util.List;

public class BaseballCalculator {

    public static Result calculateBallAndStrike(final ComputerNumber computer, final int[] input) {
        int ballCount = 0;
        int strikeCount = 0;
        return getResult(computer, input, strikeCount, ballCount);
    }

    private static Result getResult(final ComputerNumber computer, final int[] input, int strikeCount, int ballCount) {
        for (int i = 0; i < input.length; i++) {
            // 변수 할당
            if (isStrike(computer, input,i) && isBall(computer, input[i])) {
                strikeCount++;
            }else if (isBall(computer, input[i])) {
                ballCount++;
            }
        }
        return new Result(ballCount, strikeCount);
    }


    private static boolean isStrike(final ComputerNumber computer, final int[] input, int index) {
        return computer.getNumberAt(index) == input[index];
    }

    private static boolean isBall(final ComputerNumber computer, final int number) {
        return computer.containsNumber(number);
    }

}

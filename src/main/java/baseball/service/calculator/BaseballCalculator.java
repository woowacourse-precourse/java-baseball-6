package baseball.service.calculator;

import baseball.domain.computer.ComputerNumber;
import baseball.dto.Result;

public class BaseballCalculator implements Calculate {

    @Override
    public Result calculateBallAndStrike(final ComputerNumber computer, final int[] input) {
        int ballCount = 0;
        int strikeCount = 0;
        return getResult(computer, input, strikeCount, ballCount);
    }

    private static Result getResult(final ComputerNumber computer, final int[] input, int strikeCount, int ballCount) {
        for (int i = 0; i < input.length; i++) {
            // 변수 할당 - 더 리팩터링하는데는 한계인 것 같다.
            if (isStrike(computer, input, i) && isBall(computer, input[i])) {
                strikeCount++;
            } else if (isBall(computer, input[i])) {
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

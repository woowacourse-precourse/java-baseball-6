package baseball.view;

import baseball.domain.Ball;
import baseball.domain.Balls;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해 주세요 : ";

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static Balls userInputNumber() {

        List<Ball> ballList = new ArrayList<>();

        System.out.print(INPUT_MESSAGE);
        String input = readLine();

        int position = 0;
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            validateRange(digit);
            ballList.add(new Ball(digit, position++));
        }

        return new Balls(ballList);
    }

    private static void validateRange(int digit) {
        if (digit < MIN_NUMBER || MAX_NUMBER < digit) {
            throw new IllegalArgumentException();
        }
    }

}

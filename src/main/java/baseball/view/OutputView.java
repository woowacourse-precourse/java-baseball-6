package baseball.view;

import baseball.utils.GameResult;
import java.util.List;

public class OutputView {
    public static boolean outputResult(List<Integer> numberResult) {
        // TODO : 리팩토링
        Integer strikes = numberResult.get(0);
        Integer balls = numberResult.get(1);
        boolean correctAnswer = false;

        if (balls > 0) {
            System.out.print(balls + GameResult.BALL.getMessage() + " ");
        }
        if (strikes > 0) {
            System.out.println(strikes + GameResult.STRIKE.getMessage());
            if (checkAnswer(strikes)) {
                correctAnswer = true;
                System.out.println(GameResult.WIN_STRIKES.getMessage());
            }
        }
        if (balls == 0 && strikes == 0) {
            System.out.println(GameResult.NOTHING.getMessage());
        }

        return correctAnswer;
    }


    public static boolean checkAnswer(Integer strikes) {
        if (strikes.equals(3)) {
            return true;
        }
        return false;
    }
}

package baseball.view;

import baseball.utils.GameResult;
import java.util.List;

public class OutputView {
    private static final int STRIKE_INDEX_IN_NUMBER_RESULT = 0;
    private static final int BALL_INDEX_IN_NUMBER_RESULT = 1;
    private static final int REQUIRED_EXIT_WIN_STRIKES = 3;
    private static Integer strikes;
    private static Integer balls;
    private static boolean correctAnswer = false;

    public static boolean outputResult(List<Integer> numberResult) {
        getStrikeAndBall(numberResult);
        countStrikeAndBall();
        return correctAnswer;
    }

    public static void getStrikeAndBall(List<Integer> numberResult) {
        strikes = numberResult.get(STRIKE_INDEX_IN_NUMBER_RESULT);
        balls = numberResult.get(BALL_INDEX_IN_NUMBER_RESULT);
        correctAnswer = false;
    }

    public static void countStrikeAndBall() {
        countBallNumbers();
        countStrikeNumbers();
        nothingInValidResult();
    }


    public static void countBallNumbers() {
        if (balls > 0) {
            System.out.print(balls + GameResult.BALL.getMessage() + " ");
        }
    }

    public static void countStrikeNumbers() {
        if (strikes > 0) {
            System.out.println(strikes + GameResult.STRIKE.getMessage());
            if (checkAnswer(strikes)) {
                correctAnswer = true;
                System.out.println(GameResult.WIN_STRIKES.getMessage());
            }
        }
    }

    public static void nothingInValidResult() {
        if (balls == 0 && strikes == 0) {
            System.out.println(GameResult.NOTHING.getMessage());
        }
    }


    public static boolean checkAnswer(Integer strikes) {
        if (strikes.equals(REQUIRED_EXIT_WIN_STRIKES)) {
            return true;
        }
        return false;
    }
}

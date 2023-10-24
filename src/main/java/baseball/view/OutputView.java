package baseball.view;

import baseball.utils.GameResult;
import baseball.utils.RequiredGameProgress;
import java.util.List;

public class OutputView {
    private static Integer strikes;
    private static Integer balls;
    private static boolean correctAnswer = false;

    public static boolean outputResult(List<Integer> numberResult) {
        getStrikeAndBall(numberResult);
        countStrikeAndBall();
        return correctAnswer;
    }

    public static void getStrikeAndBall(List<Integer> numberResult) {
        strikes = numberResult.get(RequiredGameProgress.STRIKE_INDEX_IN_NUMBER_RESULT.getProgress());
        balls = numberResult.get(RequiredGameProgress.BALL_INDEX_IN_NUMBER_RESULT.getProgress());
        correctAnswer = false;
    }

    public static void countStrikeAndBall() {
        printBallAndStrikeNumbers();
        printBallNumbers();
        printStrikeNumbers();
        nothingInValidResult();
    }


    public static void printBallAndStrikeNumbers() {
        if (balls > 0 && strikes > 0) {
            System.out.println(balls + GameResult.BALL.getMessage() + " " + strikes + GameResult.STRIKE.getMessage());
        }
    }

    public static void printBallNumbers() {
        if (balls > 0 && strikes == 0) {
            System.out.println(balls + GameResult.BALL.getMessage());
        }
    }

    public static void printStrikeNumbers() {
        if (balls == 0 && strikes > 0) {
            System.out.println(strikes + GameResult.STRIKE.getMessage());
            checkAnswer(strikes);
        }
    }

    public static void nothingInValidResult() {
        if (balls == 0 && strikes == 0) {
            System.out.println(GameResult.NOTHING.getMessage());
        }
    }


    public static void checkAnswer(Integer strikes) {
        if (strikes.equals(RequiredGameProgress.REQUIRED_EXIT_WIN_STRIKES.getProgress())) {
            correctAnswer = true;
            System.out.println(GameResult.WIN_STRIKES.getMessage());
        }
    }
}

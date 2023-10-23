package baseball.view;

import baseball.utils.GameResult;
import java.util.List;

public class OutputView {

    private static Integer strikes;
    private static Integer balls;
    private static boolean correctAnswer = false;

    public static boolean outputResult(List<Integer> numberResult) {
        //TODO : strikes, balls 받아오는 방법 더 생각해 보기
        strikes = numberResult.get(0);
        balls = numberResult.get(1);
        correctAnswer = false;

        countBallNumbers();
        countStrikeNumbers();
        nothingInValidResult();
        return correctAnswer;
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
        if (strikes.equals(3)) {
            return true;
        }
        return false;
    }
}

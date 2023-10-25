package baseball;

import static baseball.GameState.BALL;
import static baseball.GameState.END_GAME;
import static baseball.GameState.NOTHING;
import static baseball.GameState.STRIKE;

import java.util.List;

public class Referee {
    public static boolean judge(List<Integer> computer, List<Integer> number) {
        int ballCount = judgeBall(computer, number);
        int strikeCount = judgeStrike(computer, number);
        return printJudge(ballCount, strikeCount);
    }

    private static int judgeBall(List<Integer> computer, List<Integer> number) {
        return (int) number.stream()
                .filter(n -> isBall(computer, number, n))
                .count();
    }

    private static boolean isBall(List<Integer> computer, List<Integer> number, Integer n) {
        return computer.contains(n) && computer.indexOf(n) != number.indexOf(n);
    }

    private static int judgeStrike(List<Integer> computer, List<Integer> number) {
        return (int) number.stream()
                .filter(n -> isStrike(computer, number, n))
                .count();
    }

    private static boolean isStrike(List<Integer> computer, List<Integer> number, Integer n) {
        return computer.indexOf(n) == number.indexOf(n);
    }

    private static boolean printJudge(int ballCount, int strikeCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + BALL.getMessage() + " ");
        }
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println();
        }
        if (strikeCount > 0) {
            System.out.println(strikeCount + STRIKE.getMessage());
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING.getMessage());
        }
        if (strikeCount == 3) {
            System.out.println(END_GAME.getMessage());
            return true;
        }

        return false;
    }
}

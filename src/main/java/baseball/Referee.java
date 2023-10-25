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

    private static int judgeBall(List<Integer> computer, List<Integer> number) {
        int count = 0;
        for (int i = 0; i < number.size(); i++) {
            for (int j = 0; j < computer.size(); j++) {
                if (i != j && number.get(i).equals(computer.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int judgeStrike(List<Integer> computer, List<Integer> number) {
        int count = 0;
        for (int i = 0; i < number.size(); i++) {
            if (number.get(i).equals(computer.get(i))) {
                count++;
            }
        }
        return count;
    }
}

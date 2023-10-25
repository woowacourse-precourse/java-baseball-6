package baseball;

import static baseball.GameState.BALL;
import static baseball.GameState.END_GAME;
import static baseball.GameState.NOTHING;
import static baseball.GameState.STRIKE;

import java.util.List;

public class Referee {
    private final BallCounter ballCounter = new BallCounter();
    private final StrikeCounter strikeCounter = new StrikeCounter();

    public boolean judge(List<Integer> computer, List<Integer> number) {
        int ballCount = ballCounter.count(computer, number);
        int strikeCount = strikeCounter.count(computer, number);
        return say(ballCount, strikeCount);
    }

    private boolean say(int ballCount, int strikeCount) {
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

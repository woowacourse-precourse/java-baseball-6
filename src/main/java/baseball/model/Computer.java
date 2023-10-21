package baseball.model;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {
    private Set<Ball> balls;
    private final OutputView outputView;
    private final static Integer MIN_VALUE = 1;
    private final static Integer MAX_VALUE = 9;

    public Computer() {
        outputView = new OutputView();
    }

    public void initComputerNumbers() {
        this.balls = new LinkedHashSet<>();
        while (balls.size() < 3) {
            int randomNumber = pickNumberFromThreadLocalRandomForBalls(MIN_VALUE, MAX_VALUE);
            balls.add(new Ball(randomNumber));
        }
    }

    public Integer pickNumberFromThreadLocalRandomForBalls(int minValue, int maxValue) {
        return Randoms.pickNumberInRange(minValue, maxValue);
    }

    public boolean getHintByPlayer(Set<Ball> playerBalls) {
        int ballCount = 0;
        int strikeCount = 0;
        int computeIndex = 0;
        int playerIndex = 0;
        for (Ball computeBall : balls) {
            computeIndex++;
            for (Ball playerBall : playerBalls) {
                playerIndex++;
                if (playerBall.equals(computeBall)) {
                    if (computeIndex == playerIndex) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                    playerIndex = 0;
                    break;
                }
            }

        }

        if (strikeCount == 3) {
            System.out.println();
            outputView.showGameClearMessage();
            return true;
        }
        if (strikeCount != 0 && ballCount != 0) {
            outputView.showBallAndStrikeHint(ballCount, strikeCount);
            System.out.println();
            return false;
        }
        if (strikeCount == 0 && ballCount != 0) {
            outputView.showBallOnlyHint(ballCount);
            return false;
        }
        if (strikeCount != 0) {
            outputView.showStrikeOnlyHint(strikeCount);
            return false;
        }
        outputView.showNothingHint();
        return false;
    }
}

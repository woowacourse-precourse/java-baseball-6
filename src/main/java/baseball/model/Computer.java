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
        int[] counts = computeBallAndStrikeCounts(playerBalls);
        int ballCount = counts[0];
        int strikeCount = counts[1];
        return displayHint(strikeCount, ballCount);
    }

    private int[] computeBallAndStrikeCounts(Set<Ball> playerBalls) {
        int ballCount = 0;
        int strikeCount = 0;
        int computeIndex = 0;

        for (Ball computeBall : balls) {
            computeIndex++;
            int playerIndex = 0;
            for (Ball playerBall : playerBalls) {
                playerIndex++;
                if (playerBall.equals(computeBall)) {
                    if (computeIndex == playerIndex) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                    break;
                }
            }
        }

        return new int[]{ballCount, strikeCount};
    }

    private boolean displayHint(int strikeCount, int ballCount) {
        return switch (strikeCount) {
            case 3 -> {
                outputView.showStrikeOnlyHint(strikeCount);
                outputView.showGameClearMessage();
                yield true;
            }
            case 0 -> {
                if (ballCount != 0) {
                    outputView.showBallOnlyHint(ballCount);
                    yield false;
                } else {
                    outputView.showNothingHint();
                    yield false;
                }
            }
            default -> {
                if (ballCount != 0) {
                    outputView.showBallAndStrikeHint(ballCount, strikeCount);
                    yield false;
                } else {
                    outputView.showStrikeOnlyHint(strikeCount);
                    yield false;
                }
            }
        };
    }

}

package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class BallComparator {
    private static final int NUMBER_LENGTH = 3;
    private final List<Integer> computer;
    private final List<Integer> player;
    private List<Integer> ballStrikeCount;
    private int ball;
    private int strike;

    public BallComparator(List<Integer> computer, List<Integer> player) {
        this.computer = computer;
        this.player = player;
        ball = 0;
        strike = 0;
        setBallStrikeCount();
    }

    public List<Integer> getBallStrikeCount() {
        return ballStrikeCount;
    }

    public void setBallStrikeCount() {
        ballStrikeCount = new ArrayList<>();
        calculateBallCount();
        calculateStrikeCount();
        ballStrikeCount.add(ball);
        ballStrikeCount.add(strike);
    }

    private void calculateBallCount() {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            int playerIthNum = player.get(i);
            if (computer.contains(playerIthNum) && computer.get(i) != playerIthNum) {
                ball++;
            }
        }
    }

    private void calculateStrikeCount() {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computer.get(i) == player.get(i)) {
                strike++;
            }
        }
    }
}

package baseball.game;

import java.util.List;

public class Umpire {

    private static final int INIT_NUMBER = 0;
    private static final int MAX_NUMBER_SIZE = 3;
    private static final int WINNING_STRIKE_COUNT = 3;

    private final int strikeCount;
    private final int ballCount;

    public Umpire(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        this.strikeCount = getStrikeCount(computerNumbers, playerNumbers);
        this.ballCount = getBallCount(computerNumbers, playerNumbers);
        printStrikeAndBallCount(strikeCount, ballCount);
    }

    public int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = INIT_NUMBER;
        for (int i = INIT_NUMBER; i < MAX_NUMBER_SIZE; i++) {
            if (computerNumbers.get(i) == playerNumbers.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ball = INIT_NUMBER;
        for (int i = INIT_NUMBER; i < MAX_NUMBER_SIZE; i++) {
            if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
        return ball - getStrikeCount(computerNumbers, playerNumbers);
    }

    public String getBaseballResult(int strikeCount, int ballCount) {
        if (strikeCount > INIT_NUMBER && ballCount > INIT_NUMBER) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }

        if (strikeCount > INIT_NUMBER) {
            return strikeCount + "스트라이크";
        }

        if (ballCount > INIT_NUMBER) {
            return ballCount + "볼";
        }

        return "낫싱";
    }

    private void printStrikeAndBallCount(int strikeCount, int ballCount) {
        System.out.println(getBaseballResult(strikeCount, ballCount));
    }

    public boolean isGameSet() {
        return strikeCount == WINNING_STRIKE_COUNT;
    }
}

package baseball.domain;

import baseball.constant.GameConstants;

import java.util.List;

public class Score {

    private int strike;
    private int ball;

    public void calculateScore(List<Integer> result, List<Integer> playerNumbers) {
        for (int i = 0; i < result.size(); i++) {
            int resultNumber = result.get(i);
            int playerNumber = playerNumbers.get(i);
            if (resultNumber == playerNumber) {
                increaseStrike();
                continue;
            }

            if (result.contains(playerNumber)) {
                increaseBall();
            }
        }
    }

    public void printScore() {
        StringBuilder result = new StringBuilder();
        if (getBall() != 0) {
            result.append(getBall()).append(GameConstants.BALL).append(' ');
        }

        if (getStrike() != 0) {
            result.append(getStrike()).append(GameConstants.STRIKE);
        }

        if (getStrike() == 0 && getBall() == 0) {
            result.append(GameConstants.NOTHING);
        }

        System.out.println(result);
    }

    private void increaseStrike() {
        strike += 1;
    }

    private void increaseBall() {
        ball += 1;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

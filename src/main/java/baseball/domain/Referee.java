package baseball.domain;

import java.util.List;

public class Referee {

    private int strike = 0;
    private int ball = 0;
    private int miss = 0;

    private static final int CAPACITY = 3;

    public void judge(List<Integer> numbers, int[] inputNumbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int currentTarget = inputNumbers[i];
            if (numbers.get(i) == currentTarget) {
                addStrikeCount();
            } else {
                if (numbers.contains(currentTarget)) {
                    addBallCount();
                } else {
                    addMissCount();
                }
            }
        }
    }

    public boolean isAllStrike() {
        if (this.strike == CAPACITY) {
            return true;
        }
        return false;
    }

    public void clearCount() {
        this.strike = 0;
        this.ball = 0;
        this.miss = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getMiss() {
        return miss;
    }

    private void addStrikeCount() {
        this.strike++;
    }

    private void addBallCount() {
        this.ball++;
    }

    private void addMissCount() {
        this.miss++;
    }

}

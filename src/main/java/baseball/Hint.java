package baseball;

import java.util.ArrayList;

public class Hint {
    private int ball;
    private int strike;

    public Hint() {
    }

    public static Hint getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final Hint INSTANCE = new Hint();
    }

    public void makeHint(ArrayList<Integer> playerNums, ArrayList<Integer> computerNums) {
        int tempBall = 0;
        int tempStrike = 0;

        for (int i = 0; i < computerNums.size(); i++) {
            int p = (int) playerNums.get(i);
            int c = (int) computerNums.get(i);
            if (playerNums.contains(c)) {
                if (p == c) {
                    tempStrike += 1;
                } else {
                    tempBall += 1;
                }
            }
        }

        setHint(tempBall, tempStrike);
    }

    private void setHint(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}

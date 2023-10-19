package baseball;

import java.util.List;

public class Round {
    private StrikeAndBall strikeAndBall = new StrikeAndBall(0, 0);

    public StrikeAndBall judge(List<Integer> myInt, List<Integer> comInt) {
        for (int i = 0; i < 3; i++) {
            if (myInt.get(i).equals(comInt.get(i))) {
                strikeAndBall.strike++;
                continue;
            }
            if (comInt.contains(myInt.get(i))) {
                strikeAndBall.ball++;
            }
        }
        return strikeAndBall;
    }

    static class StrikeAndBall {
        private int strike;
        private int ball;

        public StrikeAndBall(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        public int getStrike() {
            return strike;
        }

        public int getBall() {
            return ball;
        }
    }
}

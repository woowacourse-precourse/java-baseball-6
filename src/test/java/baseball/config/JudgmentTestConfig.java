package baseball.config;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.utils.RandomNumberGenerator;

public class JudgmentTestConfig {

    public static class TestComputer extends Computer {
        private final int ball;
        private final int strike;

        public TestComputer(int ball, int strike) {
            super(new RandomNumberGenerator());
            this.ball = ball;
            this.strike = strike;
        }

        @Override
        public int countSameIndexNumber(Player player) {
            return strike;
        }

        @Override
        public int countContainNumber(Player player) {
            return ball + strike;
        }
    }
}

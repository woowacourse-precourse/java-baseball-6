package baseball.config;

import baseball.domain.Judgment;

public class JudgmentTestConfig {

    public static class TestJudgment extends Judgment {
        public static final int NUMBER_SIZE = 3;
        private final int ball;
        private final int strike;

        public TestJudgment(int ball, int strike) {
            this.ball = ball;
            this.strike = strike;
        }

        public Boolean isBallAndStrike() {
            return ball > 0 && strike > 0;
        }

        public Boolean isBall() {
            return ball > 0 && strike == 0;
        }

        public Boolean isAllStrike() {
            return ball == 0 && strike == NUMBER_SIZE;
        }

        public Boolean isStrike() {
            return ball == 0 && strike > 0;
        }

        public Boolean isNothing() {
            return ball == 0 && strike == 0;
        }
    }
}

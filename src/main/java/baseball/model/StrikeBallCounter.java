package baseball.model;


public class StrikeBallCounter {

    public static final class StrikeBallCounterData {
        private final int strike;
        private final int ball;

        private StrikeBallCounterData(int strike, int ball) {
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

    public StrikeBallCounterData createStrikeBall(String playerInput, String computerNumber) {
        int localStrike = 0;
        int localBall = 0;

        for (int i = 0; i < playerInput.length(); i++) {
            localStrike += strikeCount(playerInput, computerNumber, i);
            localBall += ballCount(playerInput, computerNumber, i);
        }
        return new StrikeBallCounterData(localStrike, localBall);
    }

    private int strikeCount(String playerInput, String computerNumber, int i) {
        int computerIndex = computerNumber.indexOf(playerInput.charAt(i));
        if (computerIndex == i) {
            return 1;
        }
        return 0;
    }

    private int ballCount(String playerInput, String computerNumber, int i) {
        int computerIndex = computerNumber.indexOf(playerInput.charAt(i));
        if (computerIndex != i && computerIndex != -1) {
            return 1;
        }
        return 0;
    }
}
package baseball.model;

public class StrikeBallCounter {

    public static class StrikeBall {
        private int strike = 0;
        private int ball = 0;

        private StrikeBall(int strike, int ball) {
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

    public StrikeBall createStrikeBall(String playerInput, String computerNumber) {
        int localStrike = 0;
        int localBall = 0;

        for (int i = 0; i < playerInput.length(); i++) {
            localStrike += strikeCount(playerInput, computerNumber, i);
            localBall += ballCount(playerInput, computerNumber, i);
        }
        return new StrikeBall(localStrike, localBall);
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

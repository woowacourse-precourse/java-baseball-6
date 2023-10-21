package baseball.mytest.model;

public class StrikeBallCounter {


    public static class CompareResult {
        private int strike = 0;
        private int ball = 0;
        
        private CompareResult(int strike, int ball) {
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

    public CompareResult compare(String playerInput, String computerNumber) {
        int localStrike = 0;
        int localBall = 0;

        for (int i = 0; i < playerInput.length(); i++) {
            localStrike += strikeCount(playerInput, computerNumber, i);
            localBall += ballCount(playerInput, computerNumber, i);
        }
        return new CompareResult(localStrike, localBall);
    }

    private int strikeCount(String playerInput, String computerNumber, int i) {
        if (computerNumber.indexOf(playerInput.charAt(i)) == i) {
            return 1;
        }
        return 0;
    }

    private int ballCount(String playerInput, String computerNumber, int i) {
        if (computerNumber.indexOf(playerInput.charAt(i)) != i) {
            return 1;
        }
        return 0;
    }
}

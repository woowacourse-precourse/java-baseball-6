package baseball;

public class BallCount {
    private int strikeCount;
    private int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void calculate(String computerNumber, String userNumber){
        calculateStrikeCount(computerNumber, userNumber);
        calculateBallCount(computerNumber, userNumber);
    }

    private void calculateStrikeCount(String computerNumber, String userNumber) {
        strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.charAt(i) == userNumber.charAt(i)) {
                strikeCount++;
            }
        }
    }

    private void calculateBallCount(String computerNumber, String userNumber) {
        ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && computerNumber.charAt(i) == userNumber.charAt(i)) {
                    ballCount++;
                }
            }
        }
    }
}

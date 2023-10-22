package baseball;

public class BallCount {
    private int strikeCount;
    private int ballCount;

    void calculateStrikeCount(String computerNumber, String userNumber) {
        strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.charAt(i) == userNumber.charAt(i)) {
                strikeCount++;
            }
        }
    }

    void calculateBallCount(String computerNumber, String userNumber) {
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

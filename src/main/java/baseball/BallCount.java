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
}

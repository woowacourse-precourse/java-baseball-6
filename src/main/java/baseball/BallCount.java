package baseball;

public record BallCount(int strikes, int balls) {

    int getStrikes() {
        return strikes;
    }

    int getBalls() {
        return balls;
    }
}
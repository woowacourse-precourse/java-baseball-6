package baseball.domain.ball;

public record BallNumber(
        int number
) {
    private static final int MIN_BALL_NUMBER = 1;

    private static final int MAX_BALL_NUMBER = 9;

    public BallNumber {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException("BallNumbers는 1~9 사이의 3자리 수여야 합니다.");
        }
    }

}

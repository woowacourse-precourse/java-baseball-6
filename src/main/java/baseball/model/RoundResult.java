package baseball.model;

public record RoundResult(int strikeCount, int ballCount) {

    public boolean isRoundEnd() {
        return strikeCount == NumberFormat.DIGIT_CONSTRAINT;
    }
}

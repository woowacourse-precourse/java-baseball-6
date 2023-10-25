package baseball.dto;

public record PlayResult(
        int strikeCount,
        int ballCount
) {

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }
}

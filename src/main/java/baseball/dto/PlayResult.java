package baseball.dto;

public record PlayResult(
        int strikeCount,
        int ballCount
) {

    public boolean isNothing() {
        if (strikeCount == 0 && ballCount == 0) {
            return true;
        }

        return false;
    }
}

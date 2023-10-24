package baseball;

public class NumberBaseballGameResult {

    private final int totalCount;
    private final int strikeCount;
    private final int ballCount;

    public NumberBaseballGameResult(int totalCount, int strikeCount, int ballCount) {
        this.totalCount = totalCount;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isAllStrike() {
        return totalCount == strikeCount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (ballCount != 0) {
            result.append(ballCount).append("볼 ");
        }
        if (strikeCount != 0) {
            result.append(strikeCount).append("스트라이크");
        }

        return result.toString().trim();
    }
}

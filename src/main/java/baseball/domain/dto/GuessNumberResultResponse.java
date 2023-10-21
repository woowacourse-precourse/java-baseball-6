package baseball.domain.dto;

public class GuessNumberResultResponse {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String BLANK = " ";

    private final String result;

    private GuessNumberResultResponse(final String result) {
        this.result = result;
    }

    public static GuessNumberResultResponse of(final int ballCount, final int strikeCount) {
        return new GuessNumberResultResponse(ballCount + BALL + BLANK + strikeCount + STRIKE);
    }
    public static GuessNumberResultResponse from(final String result) {
        return new GuessNumberResultResponse(result);
    }

    public String getResult() {
        return result;
    }
}

package baseball.util.parser;

public class MatchResultParserImpl implements MatchResultParser {
    private final String RESULT_BALL = "볼";
    private final String RESULT_STRIKE = "스트라이크";
    private final String RESULT_NOTHING = "낫싱";

    @Override
    public String parse(int ballCount, int strikeCount) {
        if ( strikeCount + ballCount == 0 )
            return RESULT_NOTHING;

        if ( ballCount == 0 )
            return strikeCount + RESULT_STRIKE;

        if ( strikeCount == 0 )
            return ballCount + RESULT_BALL;

        return ballCount + RESULT_BALL + " " + strikeCount + RESULT_STRIKE;
    }
}

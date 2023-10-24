package baseball;

public record GameResult(int strikeCnt, int ballCnt) {
    public static final String STRIKE_FORMAT = "%d스트라이크";
    public static final String BALL_FORMAT = "%d볼 ";
    public static final String NOTHING_FORMAT = "낫싱";

    public boolean isComplete() {
        return strikeCnt == 3;
    }

    public boolean isNothing() {
        return strikeCnt + ballCnt == 0;
    }

    public String resultToString() {
        if (isNothing()) {
            return NOTHING_FORMAT;
        }

        StringBuilder sb = new StringBuilder();
        if (ballCnt > 0) {
            sb.append(String.format(BALL_FORMAT, ballCnt));
        }
        if (strikeCnt > 0) {
            sb.append(String.format(STRIKE_FORMAT, strikeCnt));
        }
        return sb.toString();
    }
}

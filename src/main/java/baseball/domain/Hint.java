package baseball.domain;

public class Hint {

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    private final int ballCount;
    private final int strikeCount;

    public Hint(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }

        StringBuilder sb = new StringBuilder();
        if (ballCount != 0) {
            sb.append(ballCount).append(BALL);
        }

        if(strikeCount != 0) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(strikeCount).append(STRIKE);
        }

        return sb.toString();
    }


}

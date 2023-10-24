package baseball;

public enum Score {
    THREE_STRIKE("3스트라이크", 0, 3),
    NOTHING("낫싱", 0, 0),
    TWO_STRIKE("2스트라이크", 0, 2),
    ONE_STRIKE("1스트라이크", 0, 1),
    TWO_BALL_ONE_STRIKE("2볼 1스트라이크", 2, 1),
    ONE_BALL_ONE_STRIKE("1볼 1스트라이크", 1, 1),
    TWO_BALL("2볼", 2, 0),
    ONE_BALL("1볼", 1, 0);

    private final String name;
    private final int ballCnt;
    private final int strikeCnt;

    Score(String name, int ballCnt, int strikeCnt) {
        this.name = name;
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    public static Score toScore(int ballCnt, int strikeCnt) {
        for (Score score : Score.values()) {
            if (score.ballCnt == ballCnt && score.strikeCnt == strikeCnt) {
                return score;
            }
        }
        return NOTHING;
    }

    public String getName() {
        return name;
    }
}

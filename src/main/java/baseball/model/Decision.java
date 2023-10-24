package baseball.model;

public class Decision {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크";
    private static final int BASEBALL_SIZE = 3;

    public String decide(BaseballNumber offense, BaseballNumber defense) {
        int strike = 0, ball = 0;
        for (int position = 0; position < BASEBALL_SIZE; position++) {
            if (offense.getPosition(position) == defense.getPosition(position)) {
                strike += 1;
                continue;
            }
            ball += 1;
        }
        return convert(strike, ball);
    }

    private String convert(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            return NOTHING;
        }
        if (ball == 0 && strike != 0) {
            return String.format(STRIKE, strike);
        }
        if (ball != 0 && strike == 0) {
            return String.format(BALL, ball);
        }
        return String.format(BALL_AND_STRIKE, ball, strike);
    }
}

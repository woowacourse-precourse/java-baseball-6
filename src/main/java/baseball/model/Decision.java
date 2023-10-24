package baseball.model;

public class Decision {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크";
    private static final int BASEBALL_SIZE = 3;

    public String decide(BaseballNumber offense, BaseballNumber defense) {
        int strike = countStrike(offense, defense);
        int ball = countBall(offense, defense, strike);
        return convert(strike, ball);
    }

    private int countStrike(BaseballNumber offense, BaseballNumber defense) {
        int strike  = 0;
        for (int position = 0; position < BASEBALL_SIZE; position++) {
            if (offense.getPosition(position) == defense.getPosition(position)) {
                strike += 1;
            }
        }
        return strike;
    }

    private int countBall(BaseballNumber offense, BaseballNumber defense, int strike) {
        int totalSame = 0;
        for (int position = 0; position < BASEBALL_SIZE; position++) {
            if (defense.contain(offense.getPosition(position))) {
                totalSame += 1;
            }
        }
        return totalSame - strike;
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

    public boolean isEnd(String judgement) {
        return judgement.equals(String.format(STRIKE, BASEBALL_SIZE));
    }
}

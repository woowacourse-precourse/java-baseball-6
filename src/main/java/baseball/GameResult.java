package baseball;

public class GameResult {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private final int strikeCnt;
    private final int ballCnt;


    public GameResult(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }


    public static GameResult compareBalls(RandomBalls randomBalls, UserBalls userBalls) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < RandomBalls.BALLS_COUNT; i++) {
            int currentBall = randomBalls.getBall(i);

            if (currentBall == userBalls.getBall(i)) {
                strikeCnt++;
            } else if (userBalls.contains(currentBall)) {
                ballCnt++;
            }
        }
        return new GameResult(strikeCnt, ballCnt);
    }

    public String getResultMessage() {
        if (isNothing()) {
            return NOTHING;
        } else if (isStrikeOnly()) {
            return strikeCnt + STRIKE;
        } else if (isBallOnly()) {
            return ballCnt + BALL;
        }
        return ballCnt + BALL + " " + strikeCnt + STRIKE;
    }

    private boolean isBallOnly() {
        return (strikeCnt == 0) && (ballCnt > 0);
    }

    private boolean isStrikeOnly() {
        return (strikeCnt > 0) && (ballCnt == 0);
    }

    private boolean isNothing() {
        return (strikeCnt == 0) && (ballCnt == 0);
    }

    public boolean isAllStrikes() {
        if (strikeCnt == RandomBalls.BALLS_COUNT) {
            printGameEndMessage();
            return true;
        }
        return false;
    }

    private void printGameEndMessage() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", RandomBalls.BALLS_COUNT);
    }
}

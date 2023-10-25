package baseball.domain;

public class GameResult {

    private final static String GAME_SUCCESS_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String BALL_MSG = "볼 ";
    private final static String STRIKE_MSG = "스트라이크";
    private final static String NOTHING_MSG = "낫싱";
    private final static int OUT_COUNT = 3;

    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ball, int strike) {
        this.ballCount = ball;
        this.strikeCount = strike;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void display() {
        if (strikeCount == OUT_COUNT) {
            System.out.println(strikeCount + STRIKE_MSG);
            System.out.println(GAME_SUCCESS_MSG);
        }
        else if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING_MSG);
        }
        else  {
            if (ballCount > 0) System.out.print(ballCount + BALL_MSG);
            if (strikeCount > 0) System.out.print(strikeCount + STRIKE_MSG);
            System.out.println();
        }
    }


}

package baseball;

public class Score {
    private static final String BALL_STR = "볼";
    private static final String STRIKE_STR = "스트라이크";
    private static final String NOTHING = "낫싱";

    private int[] player;
    private int[] computer;

    private int strike;
    private int ball;

    public Score() {}

    public Score(int[] player, int[] computer) {
        this.player = player;
        this.computer = computer;
    }

    public void printResult() {
        System.out.println(getResultString());
    }

    private String getResultString() {
        if(strike == 0 && ball == 0) {
            return NOTHING;
        }

        StringBuilder sb = new StringBuilder();
        if(ball > 0) {
            sb.append(ball).append(BALL_STR);
        }
        if(strike > 0) {
            sb.append(strike).append(STRIKE_STR);
        }
        return sb.toString();
    }
}
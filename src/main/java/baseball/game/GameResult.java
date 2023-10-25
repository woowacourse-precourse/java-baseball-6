package baseball.game;

public class GameResult {

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void print() {
        StringBuilder result = new StringBuilder();

        if (ball != 0) {
            result.append(String.format("%d%s", this.ball, GameConst.BALL));
        }

        if (strike != 0) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(String.format("%d%s", this.strike, GameConst.STRIKE));
        }

        if (result.isEmpty()) {
            result.append(GameConst.NOTHING);
        }

        System.out.println(result);
    }

    public boolean gameEnd() {
        return this.strike == GameConst.NUMBER_SIZE;
    }
}

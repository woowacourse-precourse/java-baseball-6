package baseball.game;

public class GameResult {

    public int strike;
    public int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void print() {
        StringBuilder result = new StringBuilder();
        if (ball != 0) {
            result.append(String.format("%d볼", this.ball));
        }
        if (strike != 0) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(String.format("%d스트라이크", this.strike));
        }

        if (result.isEmpty()) {
            result.append("낫싱");
        }

        System.out.println(result);
    }
}

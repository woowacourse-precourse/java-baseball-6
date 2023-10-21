package baseball.domain;

public class GameResult {

    private final int strike;
    private final int ball;
    private final int THREE_STRIKE = 3;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getResult() {
        String result = "";

        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            result += "낫싱";
        }
        if (strike == THREE_STRIKE) {
            result += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        return result;
    }

    public boolean isWin() {
        return strike == THREE_STRIKE;
    }
}

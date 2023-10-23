package baseball;

public class GameResult {

    private String result;

    public GameResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            this.result = "낫싱";
        } else if (ball == 0 && strike != 0) {
            this.result = strike + "스트라이크";
        } else if (ball != 0 && strike == 0) {
            this.result = ball + "볼";
        } else {
            this.result = ball + "볼" + " " + strike + "스트라이크";
        }
        System.out.println(result);
    }

    public String getResult() {
        return result;
    }
}

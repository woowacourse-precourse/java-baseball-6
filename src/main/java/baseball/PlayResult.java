package baseball;

public class PlayResult {

    private int strike = 0;
    private int ball = 0;

    public void result(String result) {
        if (result == "스트라이크") {
            strike++;
        }

        if (result == "볼") {
            ball++;
        }

    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

package baseball.domain;

public class Game {
    int strike;
    int ball;
    int[] result_arr;

    public void intiField() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return strike;
    }


    public int getBall() {
        return ball;
    }


    public int[] getResult_arr() {
        return result_arr;
    }

    public void setResult_arr(int[] result_arr) {
        this.result_arr = result_arr;
    }

    public void strikeCount() {
        strike++;
    }

    public void ballCount() {
        ball++;
    }
}

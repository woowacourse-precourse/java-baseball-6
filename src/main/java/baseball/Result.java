package baseball;

public class Result {
    int ball = 0;
    int strike = 0;

    @Override
    public String toString() {
        if (strike == 3) { return "3스트라이크"; }
        else if (ball == 0 && strike == 0) { return "낫싱"; }
        else { return ball+"볼" + " " + strike + "strike"; }
    }
}

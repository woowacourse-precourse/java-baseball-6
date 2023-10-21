package baseball.mytest.model;

public class ResultOfGame {
    public String result(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return ("낫싱");
        }
        if (ball == 0) {
            return (strike + "스트라이크");
        }
        if (strike == 0) {
            return (ball + "볼");
        }
        return (ball + "볼 " + strike + "스트라이크");
    }
}

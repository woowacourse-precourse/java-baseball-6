package baseball.mytest.model;

public class ResultOfGame {
    public String result(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return ("낫싱");
        }
        if (strike == 3) {
            return ("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
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

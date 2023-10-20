package baseball.number;

import java.util.StringJoiner;

public class BaseballResult {
    public int ball = 0;
    public int strike = 0;

    public void print() {
        StringJoiner sj = new StringJoiner(" ");
        if (ball != 0) {
            sj.add(ball + "볼");
        }
        if (strike != 0) {
            sj.add(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            sj.add("낫싱");
        }
        System.out.println(sj);
    }

    public boolean isCorrect() {
        return strike == 3;
    }
}
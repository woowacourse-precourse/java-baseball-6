package baseball.domain;

import java.util.List;

public class Computer {
    private static List<Integer> answer;
    private static int strike;
    private static int ball;

    public static int getStrike() {
        return strike;
    }

    public static void setStrike(int strike) {
        Computer.strike = strike;
    }

    public static int getBall() {
        return ball;
    }

    public static void setBall(int ball) {
        Computer.ball = ball;
    }

    public static List<Integer> getAnswer() {
        return answer;
    }

    public static void setAnswer(List<Integer> answer) {
        Computer.answer = answer;
    }
}

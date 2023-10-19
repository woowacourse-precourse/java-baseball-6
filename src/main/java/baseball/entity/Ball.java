package baseball.entity;

import baseball.common.Size;

public class Ball {
    private final String answer;
    private int ball;
    private int strike;
    private String hit;

    public Ball(int answer) {
        this.answer = Integer.toString(answer);
        ball = 0;
        strike = 0;
        hit = "";
    }

    private void reset(int input) {
        hit = Integer.toString(input);
        ball = 0;
        strike = 0;
    }

    public int[] compareBall(int input) {
        reset(input);
        for (int i = 0; i < Size.NUMBER.getValue(); i++) {
            checkStrike(i);
            checkBall(i);
        }
        return new int[]{ball, strike};
    }

    private void checkBall(int index) {
        for (int i = 0; i < Size.NUMBER.getValue(); i++) {
            if (i != index && answer.charAt(i) == hit.charAt(index)) {
                ball++;
                break;
            }
        }
    }

    private void checkStrike(int i) {
        if (answer.charAt(i) == hit.charAt(i)) {
            strike++;
        }
    }
}

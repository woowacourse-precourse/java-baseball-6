package baseball.entity;

import baseball.common.Size;

public class Ball {
    private final String answer;

    public Ball(int answer) {
        this.answer = Integer.toString(answer);
    }

    public int[] compareBall(int input) {
        int ball = 0;
        int strike = 0;

        String hit = Integer.toString(input);
        for (int i = 0; i < Size.NUMBER.getValue(); i++) {
            strike += checkStrike(i, hit);
            ball += checkBall(i, hit);
        }
        return new int[]{ball, strike};
    }

    private int checkBall(int index, String hit) {
        for (int i = 0; i < Size.NUMBER.getValue(); i++) {
            if (i != index && answer.charAt(i) == hit.charAt(index)) {
                return 1;
            }
        }
        return 0;
    }

    private int checkStrike(int i, String hit) {
        if (answer.charAt(i) == hit.charAt(i)) {
            return 1;
        }
        return 0;
    }
}

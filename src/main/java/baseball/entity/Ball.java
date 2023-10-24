package baseball.entity;

import baseball.common.Size;

import java.util.List;

public class Ball {
    private final List<Integer> answer;
    private List<Integer> hit;

    public Ball(List<Integer> answer) {
        this.answer = answer;
    }

    public int[] compareBall(List<Integer> hit) {
        int ball = 0;
        int strike = 0;

        this.hit = hit;
        for (int i = 0; i < Size.NUMBER.getValue(); i++) {
            strike += checkStrike(i);
            ball += checkBall(i);
        }
        return new int[]{ball, strike};
    }

    private int checkBall(int index) {
        for (int i = 0; i < Size.NUMBER.getValue(); i++) {
            if (i != index && answer.get(i).equals(hit.get(index))) {
                return 1;
            }
        }
        return 0;
    }

    private int checkStrike(int i) {
        if (answer.get(i).equals(hit.get(i))) {
            return 1;
        }
        return 0;
    }
}

package baseball.util;

import java.util.List;

public class NumberCompare {
    private int ball = 0;
    private int strike = 0;

    public NumberCompare() {
        this.ball = 0;
        this.strike = 0;
    }

    public void reset() {
        this.ball = 0;
        this.strike = 0;
    }

    public int[] CompareNumber(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                this.strike++;
                continue;
            }
            if (computer.contains((user.get(i)))) {
                this.ball++;
                continue;
            }
        }
        int[] arr = new int[] { this.ball, this.strike };
        if (this.strike != 3) {
            reset();
        }
        return arr;
    }

    public int getStrike() {
        return this.strike;
    }
}

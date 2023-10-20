package baseball;

import java.util.List;

public class Rules {

    private int ball;
    private int strikes;

    private void initBallsAndStrikes() {
        this.ball = 0;
        this.strikes = 0;
    }

    public void countBallAndStrikes(List<Integer> com, List<Integer> user) {
        initBallsAndStrikes();
        for (Integer val : user) {
            int c_idx = com.indexOf(val);
            int u_idx = user.indexOf(val);
            if (!com.contains(val)) {
                continue;
            }
            if (c_idx >= 0 && c_idx == u_idx) {
                this.strikes++;
            }
            if (c_idx >= 0 && c_idx != u_idx) {
                this.ball++;
            }
        }
    }

    public void printBallAndStrikes() {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        if (ball == 0 && strikes == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public boolean isThreeStrikes() {
        return strikes == 3;
    }
}

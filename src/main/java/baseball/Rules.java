package baseball;

import java.util.List;

public class Rules {

    private int ball;
    private int strikes;

    private void initBallsAndStrikes(int num1, int num2) {
        this.ball = 0;
        this.strikes = 0;
    }

    public void countBallAndStrikes(List<Integer> com, List<Integer> user) {
        initBallsAndStrikes(0, 0);
        for (Integer val : user) {
            if (com.indexOf(val) < 0) {
                continue;
            }
            if (com.indexOf(val) == user.indexOf(val)) {
                this.strikes++;
            }
            if (com.indexOf(val) != user.indexOf(val)) {
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

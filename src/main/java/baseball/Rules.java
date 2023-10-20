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
            if (!com.contains(val)) {
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
        if (ball > 0 && strikes == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strikes > 0) {
            System.out.println(strikes + "스트라이크");
        }
        if (ball > 0 && strikes > 0) {
            System.out.println(ball + "볼 " + strikes + "스트라이크");
        }
        if (ball == 0 && strikes == 0) {
            System.out.println("낫싱");
        }
    }

    public boolean isThreeStrikes() {
        return strikes == 3;
    }
}

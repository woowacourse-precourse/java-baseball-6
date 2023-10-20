package baseball;

import java.util.List;

public class Rules {

    private int ball;
    private int strikes;

    public void init(int num1, int num2) {
        this.ball = 0;
        this.strikes = 0;
    }

    public void countBallAndStrikes(Computer com, List<Integer> player) {
        for (Integer val : player) {
            int index = com.isInList(val);
            if (index < 0) {
                continue;
            }
            if (index == player.indexOf(val)) {
                this.strikes++;
            }
            if (index != player.indexOf(val)) {
                this.ball++;
            }
        }
    }

    public void getResult() {
        if (strikes == 3) {
            System.out.println(strikes + "스트라이크");
            return;
        }

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
}

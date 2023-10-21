package baseball;

import java.util.List;

public class Rules {

    private int balls;
    private int strikes;

    private void initBallsAndStrikes() {
        this.balls = 0;
        this.strikes = 0;
    }

    public void countBallAndStrikes(List<Integer> user, List<Integer> com) {
        initBallsAndStrikes();
        for (Integer userNum : user) {
            int c_idx = com.indexOf(userNum);
            int u_idx = user.indexOf(userNum);
            if (!com.contains(userNum)) {
                continue;
            }
            if (userNum.equals(com.get(c_idx)) && c_idx == u_idx) {
                strikes++;
            } else if (userNum.equals(com.get(c_idx)) && c_idx != u_idx) {
                balls++;
            }
        }
    }

    public boolean isThreeStrikes() {
        return strikes == 3;
    }

    public void printIfAnswer() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printIfNotAnswer() {
        hasNothing();
        hasBallOrStrike();
    }

    private void hasNothing() {
        if (balls == 0 && strikes == 0) {
            System.out.print("낫싱");
        }
    }

    private void hasBallOrStrike() {
        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }
        System.out.println();
    }
}

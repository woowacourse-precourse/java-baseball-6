package baseball;

import java.util.List;

public class Rules {    // 볼, 스트라이크 개수 규칙 관련 클래스

    private int balls;
    private int strikes;

    public Rules() {
        initBallsAndStrikes();
    }

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
            if (userNum.equals(com.get(c_idx)) && c_idx != u_idx) {
                balls++;
            } else if (userNum.equals(com.get(c_idx)) && c_idx == u_idx) {
                strikes++;
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
        System.out.println();
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
    }
}

package baseball;

import java.util.List;

public class Judgment {
    final private List<Integer> computer;
    final private List<Integer> user;
    private int strike;
    private int ball;

    public Judgment(List<Integer> computer, List<Integer> user) {
        this.computer = computer;
        this.user = user;

        initJudgment();
    }

    private void initJudgment() {
        strike = 0;
        ball = 0;
    }

    public void judgeStrike() {
        for (int index = 0; index < 3; index++) {
            if (computer.get(index).equals(user.get(index))) {
                strike += 1;
            }
        }
    }

    private boolean isBall(int currentIndex) {
        int userNumber = user.get(currentIndex);

        for (int index = 0; index < 3; index++) {
            if (index != currentIndex && computer.get(index).equals(userNumber)) {
                return true;
            }
        }

        return false;
    }

    public void judgeBall() {
        for (int index = 0; index < 3; index++) {
            if (isBall(index)) {
                ball += 1;
            }
        }
    }

    public boolean isUserWin() {
        if (strike == 3) {
            initJudgment();
            return true;
        }

        initJudgment();
        return false;
    }

    public void judge() {
        judgeStrike();
        judgeBall();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}

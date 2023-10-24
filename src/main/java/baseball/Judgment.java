package baseball;

import java.util.List;

public class Judgment {
    private int strike;
    private int ball;

    public Judgment() {
        initializeJudgment();
    }

    private void initializeJudgment() {
        strike = 0;
        ball = 0;
    }

    private void judgeStrike(List<Integer> computer, List<Integer> user) {
        for (int index = 0; index < 3; index++) {
            if (computer.get(index).equals(user.get(index))) {
                strike += 1;
            }
        }
    }

    private boolean isBall(int currentIndex, List<Integer> computer, List<Integer> user) {
        int userNumber = user.get(currentIndex);

        for (int index = 0; index < 3; index++) {
            if (index != currentIndex && computer.get(index).equals(userNumber)) {
                return true;
            }
        }

        return false;
    }

    private void judgeBall(List<Integer> computer, List<Integer> user) {
        for (int index = 0; index < 3; index++) {
            if (isBall(index, computer, user)) {
                ball += 1;
            }
        }
    }

    public boolean isUserWin() {
        if (strike == 3) {
            initializeJudgment();
            return true;
        }

        initializeJudgment();
        return false;
    }

    public void judge(List<Integer> computer, List<Integer> user) {
        judgeStrike(computer, user);
        judgeBall(computer, user);

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

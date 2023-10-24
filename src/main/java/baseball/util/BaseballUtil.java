package baseball.util;

import baseball.constant.ApplicationConstant;

import java.util.List;

public class BaseballUtil {
    private int ball;
    private int strike;

    private BaseballUtil() {
    }

    public static BaseballUtil of() {
        return new BaseballUtil();
    }

    public void getBaseballCount(List<Integer> computer, List<Integer> player) {
        int ball = getBallCount(computer, player);
        int strike = getStrikeCount(computer, player);
    }

    public boolean isBall(int index, List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == player.get(index) && i != index) {
                return true;
            }
        }
        return false;
    }

    public boolean isStrike(int index, List<Integer> computer, List<Integer> player) {
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == player.get(index) && i == index) {
                return true;
            }
        }
        return false;
    }

    public int getBallCount(List<Integer> computer, List<Integer> player) {
        ball = 0;
        for (int i = 0; i < player.size(); i++) {
            if (isBall(i, computer, player)) {
                ball++;
            }
        }
        return ball;
    }

    public int getStrikeCount(List<Integer> computer, List<Integer> player) {
        strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (isStrike(i, computer, player)) {
                strike++;
            }
        }
        return strike;
    }

    public void printResult() {
        if (ball > 0) {
            System.out.print(ball + ApplicationConstant.BALL);
        }
        if (strike > 0) {
            System.out.print(strike + ApplicationConstant.STRIKE);
        }
        if (ball == 0 && strike == 0) {
            System.out.print(ApplicationConstant.NOTHING);
        }
        System.out.println();
    }
}

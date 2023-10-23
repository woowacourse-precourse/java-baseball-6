package baseball.play;

import java.util.Arrays;

public class Play {
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void ballCnt(String computerNum, String playerNum) {
        for (int i = 0; i < computerNum.length(); i++) {
            if (computerNum.contains(Character.toString(playerNum.charAt(i)))) {
                ball++;
            }
        }
    }

    public void clean() {
        ball = 0;
        strike = 0;
    }

    public int[] getPlayBall(String computerNum, String playerNum) {
        clean();
        for (char i : playerNum.toCharArray()) {
            if (computerNum.indexOf(i) == playerNum.indexOf(i)) {
                strike++;
            }
        }
        ballCnt(computerNum, playerNum);
        ball = getBall() - getStrike();
        return new int[]{ball, strike};
    }

    public boolean checkEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return true;
    }
    public boolean checkStrike() {
        if (getStrike() == 3) {
            return checkEndGame();
        }
        return false;
    }
}

package baseball;

import view.OutputView;

import java.util.*;

import static model.BaseballData.*;

public class BaseballGame {
    static List<Integer> computerNumber;
    static List<Integer> myNumber;
    static boolean finish = true;
    static int ball;
    static int strike;

    /**
     * 게임 결과 기능
     */
    public void gameResult() {
        ball = isBall();
        strike = isStrike();
        OutputView.gameResult(strike, ball);
    }

    /**
     * 볼 계산
     */
    public int isBall() {
        int count = 0;
        for (int i = 0; i < SUCCESS; i++) {
            if (!Objects.equals(computerNumber.get(i), myNumber.get(i)) && computerNumber.contains(myNumber.get(i)))
                count++;
        }
        return count;
    }

    /**
     * 스트라이크 계산
     */
    public int isStrike() {
        int count = 0;
        for (int i = 0; i < SUCCESS; i++) {
            if (Objects.equals(computerNumber.get(i), myNumber.get(i)))
                count++;
        }
        if (count == SUCCESS)
            finish = false;
        return count;
    }

    /**
     * 게임 재시작 여부
     */
    public boolean gameRestart(int restart) {
        return restart == RESTART_NUMBER;
    }
}

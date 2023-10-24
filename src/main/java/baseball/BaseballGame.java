package baseball;

import static model.BaseballData.MAX_HIT;
import static model.BaseballData.RESTART_NUMBER;

import java.util.List;
import java.util.Objects;
import view.OutputView;

public class BaseballGame {
    List<Integer> computerNumber;
    List<Integer> myNumber;
    boolean finish = true;
    int ball;
    int strike;

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
        for (int i = 0; i < MAX_HIT; i++) {
            if (!Objects.equals(computerNumber.get(i), myNumber.get(i)) && computerNumber.contains(myNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 스트라이크 계산
     */
    public int isStrike() {
        int count = 0;
        for (int i = 0; i < MAX_HIT; i++) {
            if (Objects.equals(computerNumber.get(i), myNumber.get(i))) {
                count++;
            }
        }
        if (count == MAX_HIT) {
            finish = false;
        }
        return count;
    }

    /**
     * 게임 재시작 여부
     */
    public boolean gameRestart(int restart) {
        return restart == RESTART_NUMBER;
    }
}

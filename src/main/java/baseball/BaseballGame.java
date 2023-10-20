package baseball;

import model.BaseballNumber;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static model.BaseballData.*;
import static view.OutputView.*;

public class BaseballGame {
    static List<Integer> computerNumber;
    static List<Integer> myNumber;
    static boolean finish = true;
    static int ball;
    static int strike;

    public void gameResult() {
        ball = isBall();
        strike = isStrike();
        OutputView.gameResult(strike,ball);
    }

    public int isBall() {
        int count= 0;
        for (int i = 0; i < SUCCESS; i++) {
            if (!Objects.equals(computerNumber.get(i), myNumber.get(i)) && computerNumber.contains(myNumber.get(i)))
                count++;
        }
        return count;
    }

    public int isStrike() {
        int count= 0;
        for (int i = 0; i < SUCCESS; i++) {
            if (Objects.equals(computerNumber.get(i), myNumber.get(i)))
                count++;
        }
        if (count == SUCCESS)
            finish = false;
        return count;
    }

    public boolean gameRestart(int restart) {
        return restart == RESTART_NUMBER;
    }
}

package baseball;

import model.BaseballNumber;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static model.BaseballData.*;


public class BaseballGame {
    static List<Integer> computerNumber;
    static List<Integer> myNumber;
    static boolean finish = true;

    public String gameResult() {
        StringBuilder result = new StringBuilder();
        int ball = isBall();
        int strike = isStrike();
        if (strike == 3) {
            result.append(strike).append(STRIKE);
            finish = false;
        } else if (strike ==0&&ball==0){
            result.append(NOTHING);
        } else {
            if (ball != 0)
                result.append(ball).append(BALL).append(" ");
            else
                result.append(strike).append(STRIKE);
        }
        return result.toString();
    }

    public int isBall() {
        int count= 0;
        for (int i = 0; i < 3; i++) {
            if (!Objects.equals(computerNumber.get(i), myNumber.get(i)) && computerNumber.contains(myNumber.get(i)))
                count++;
        }
        return count;
    }

    public int isStrike() {
        int count= 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNumber.get(i), myNumber.get(i)))
                count++;
        }
        return count;
    }

    public boolean gameRestart(int restart) {
        return restart == RESTART_NUMBER;
    }
}

package baseball;

import static baseball.Constant.BALL_STRING;
import static baseball.Constant.END_RANGE;
import static baseball.Constant.NOTHING_STRING;
import static baseball.Constant.NUMBER_COUNT;
import static baseball.Constant.START_RANGE;
import static baseball.Constant.STRIKE_STRING;
import static baseball.Constant.SUCCESS_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumbers = new ArrayList<>();

    public Computer() {
        while (computerNumbers.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, END_RANGE);
            if (!isContainedNumber(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        System.out.println(computerNumbers);
    }

    public boolean checkResult(List<Integer> playerList) {
        int strike = getStrike(playerList);
        int ball = getBall(playerList) - strike;

        System.out.println(getHintString(strike, ball));
        return is3Strike(strike);
    }

    private boolean isContainedNumber(int randomNumber) {
        for (Integer x : computerNumbers) {
            if (x == randomNumber) {
                return true;
            }
        }
        return false;
    }

    private String getHintString(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING_STRING;
        } else if (strike > 0 && ball == 0) {
            return strike + STRIKE_STRING;
        } else if (ball > 0 && strike == 0) {
            return ball + BALL_STRING;
        }
        return ball + BALL_STRING + " " + strike + STRIKE_STRING;
    }

    private boolean is3Strike(int strike) {
        if (strike == NUMBER_COUNT) {
            System.out.println(SUCCESS_MESSAGE);
            return true;
        }
        return false;
    }

    private int getStrike(List<Integer> playerList) {
        int strike = 0;

        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).equals(computerNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int getBall(List<Integer> playerList) {
        int ball = 0;

        for (Integer p : playerList) {
            if (computerNumbers.contains(p)) {
                ball++;
            }
        }
        return ball;
    }
}

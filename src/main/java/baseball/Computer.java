package baseball;

import static baseball.Constant.END_RANGE;
import static baseball.Constant.NUMBER_COUNT;
import static baseball.Constant.START_RANGE;

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

        Result result = new Result(strike, ball);
        System.out.println(result.getHintString());
        return result.is3Strike();
    }

    private boolean isContainedNumber(int randomNumber) {
        for (Integer x : computerNumbers) {
            if (x == randomNumber) {
                return true;
            }
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

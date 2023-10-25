package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Integer> computerNum = new ArrayList<>();
    public int ball;
    public int strike;

    public void initializeSetting() {
        generateRandomNum();
        ball = 0;
        strike = 0;
    }

    public void generateRandomNum() {
        computerNum.clear();
        while (computerNum.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            isContain(randomNum);
        }
    }

    private void isContain(int randomNum) {
        if (!computerNum.contains(randomNum)) {
            computerNum.add(randomNum);
        }
    }

    public void tryStrike(String userNum) {
        ball = 0;
        strike = 0;
        for (int numIndex = 0; numIndex < 3; numIndex++) {
            int value = Character.getNumericValue(userNum.charAt(numIndex));
            checkBallAndStrike(numIndex, value);
        }
    }

    public void checkBallAndStrike(int numIndex, int value) {
        if (!checkBall(value)) {
            return;
        }
        if (checkStrike(numIndex, value)) {
            strike++;
            return;
        }
        ball++;
    }

    private boolean checkBall(int value) {
        return computerNum.contains(value);
    }

    private boolean checkStrike(int numIndex, int value) {
        return computerNum.get(numIndex) == value;
    }
}
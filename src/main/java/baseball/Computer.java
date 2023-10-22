package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> comNumber;
    private int strike;
    private int ball;

    public void selectRandomNumbers() {
        comNumber = new ArrayList<>();
        while (comNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber);
            }
        }
    }

    private void playGame(List<Integer> userNumber) {
        strike = 0;
        ball = 0;
        countStrike(userNumber);
        countBall(userNumber);
        exceptStrikeInBall();
    }

    public void countBall(List<Integer> userNumber) {
        for (int i = 0; i < comNumber.size(); i++) {
            if (comNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }
    }

    public void countStrike(List<Integer> userNumber) {
        for (int i = 0; i < comNumber.size(); i++) {
            if (comNumber.get(i).equals(userNumber.get(i))) {
                strike++;
            }
        }
    }

    public void exceptStrikeInBall() {
        ball -= strike;
    }

    public String getGameResult(List<Integer> userNumber) {
        playGame(userNumber);
        if (strike != 0 && ball != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (strike != 0) {
            return strike + "스트라이크";
        }
        if (ball != 0) {
            return ball + "볼";
        }
        return "낫싱";
    }
}

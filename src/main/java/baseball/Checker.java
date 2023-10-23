package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Checker {

    private List<Integer> baseballNumbers;

    public void generateComputerNumbers() {
        baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getBaseballNumbers() {return baseballNumbers;}

    public boolean playerInputCheck(List<Integer> playerNumbers) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (playerNumbers.get(i).equals(baseballNumbers.get(i))) {
                strike++;
            } else if (baseballNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }

        System.out.println(gameResult(strike, ball));

        return strike == 3;
    }

    private String gameResult(int strike, int ball) {
        if (strike == 3) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (strike > 0 && ball > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else {
            return "낫싱";
        }
    }
}

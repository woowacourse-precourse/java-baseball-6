package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {

    private int strike = 0;
    private int ball = 0;

    public List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void calculateResult(List<Integer> computer, List<Integer> user) {
        strike = 0;
        ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < user.size(); j++) {
                if (computer.get(i) == user.get(j) && i == j) {
                    strike++;
                } else if (computer.get(i) == user.get(j) && i != j) {
                    ball++;
                }
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}

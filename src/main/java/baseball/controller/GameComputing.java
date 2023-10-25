package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameComputing {
    public List<Integer> generateComputerInput() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int compute(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) == player.get(i)) {
                strike++;
            }
            else if (computer.contains(player.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);
        return strike;
    }

    public void printResult(int strike, int ball) {
        String resultMessage = "";
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        else {
            if (ball != 0) {
                resultMessage += ball + "볼 ";
            }
            if (strike != 0) {
                resultMessage += strike + "스트라이크";
            }
            System.out.println(resultMessage);
        }
    }
}

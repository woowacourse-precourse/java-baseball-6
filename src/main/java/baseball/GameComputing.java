package baseball;

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

    public int compute(List<Integer> computerInput, List<Integer> userInput) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (computerInput.get(i) == userInput.get(i)) {
                strike++;
            }
            else if (computerInput.contains(userInput.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);
        return strike;
    }

    public void printResult(int strike, int ball) {
        if (strike != 0 || ball != 0) {
            if (strike == 0) {
                System.out.println(ball + "볼");
            }
            else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            }
            else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
        else {
            System.out.println("낫싱");
        }
    }
}

package baseball;

import java.util.List;

public class Implementation {

    Computer computer = new Computer();
    GameProcess gameProcess = new GameProcess();


    List<Integer> computerNumbers = computer.generateRandomNumbers();
    public int countStrike(List<Integer> computerNumbers, List<Integer> userInput) {
        int strike = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i) == userInput.get(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> computerNumbers, List<Integer> userInput) {
        int ball = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (!computerNumbers.get(i).equals(userInput.get(i)) && computerNumbers.contains(userInput.get(i))) {
                ball++;
            }
        }
        return ball;
    }
}

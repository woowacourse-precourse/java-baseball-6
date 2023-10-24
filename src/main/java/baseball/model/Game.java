package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> computerNumbers;

    public Game() {
        computerNumbers = generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private int countStrikes(List<Integer> userNumbers) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(List<Integer> userNumbers) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.contains(userNumbers.get(i)) && !computerNumbers.get(i).equals(userNumbers.get(i))) {
                balls++;
            }
        }
        return balls;
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Integer> randomNumbers;

    public Game() {
    }

    public void play() {
        randomNumbers = new ArrayList<>();

        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }
}

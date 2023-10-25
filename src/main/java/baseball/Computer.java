package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> randomNumbers;

    public Computer() {
        randomNumbers = new ArrayList<>();
        generateRandomNumbers();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
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
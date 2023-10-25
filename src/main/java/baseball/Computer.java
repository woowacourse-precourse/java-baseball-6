package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> randomNumbers;
    private final int SIZE_OF_NUMBERS = 3;

    public Computer() {
        randomNumbers = new ArrayList<>();
        generateRandomNumbers();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private void generateRandomNumbers() {
        while (randomNumbers.size() < SIZE_OF_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public boolean isCorrectGuess(int[] input) {
        for (int i = 0; i < SIZE_OF_NUMBERS; i++) {
            if (input[i] != randomNumbers.get(i)) {
                return false;
            }
        }
        return true;
    }
}
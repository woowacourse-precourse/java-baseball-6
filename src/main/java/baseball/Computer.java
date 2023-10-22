package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final RandomGenerator randomGenerator;
    private final List<Integer> randomList;

    public Computer(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.randomList = new ArrayList<>();
        insertRandomNumbers();
    }

    public void clearAndInitialize() {
        randomList.clear();
        insertRandomNumbers();
    }

    public boolean containsNumber(int number) {
        return randomList.contains(number);
    }

    public int getNumberAt(int index) {
        return randomList.get(index);
    }

    private void insertRandomNumbers() {
        while (randomList.size() < 3) {
            int randomNumber = randomGenerator.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
    }
}


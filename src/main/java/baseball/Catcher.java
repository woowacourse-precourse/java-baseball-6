package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Catcher {
    private List<Integer> numbers;
    private int maxSize;

    public Catcher(int maxSize) {
        this.numbers = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateRandomNumbers() {
        numbers.clear();
        while (numbers.size() < maxSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}

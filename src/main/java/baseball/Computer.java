package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int PICK_SIZE = 3;

    private List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
    }

    private List<Integer> init() {
        numbers.clear();
        generateNumbers();
        
        return numbers;
    }

    private void generateNumbers() {
        while (numbers.size() < PICK_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}

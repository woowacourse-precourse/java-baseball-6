package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    // member variables
    private final List<Integer> numbers;

    // constructor
    public Computer() {
        numbers = new ArrayList<>();
        // initialize numbers list
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    // getter
    public List<Integer> getNumbers() {
        return numbers;
    }

    // pick random numbers for computer method
    public void generateNumbers() {
        clearNumbers();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    // clear numbers
    private void clearNumbers(){
        numbers.clear();
    }
}

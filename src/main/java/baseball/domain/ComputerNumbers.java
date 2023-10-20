package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {
    private final List<Integer> numbers = new ArrayList<>();

    public ComputerNumbers() {
        pickNumbers();
    }

    private void pickNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    private void pickNumbers() {
        while (numbers.size() < 3) {
            pickNumber();
        }
    }

    public int get(int i) {
        return numbers.get(i);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}

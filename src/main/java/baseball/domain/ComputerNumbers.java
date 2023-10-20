package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {
    private final List<Integer> numbers = new ArrayList<>();

    public ComputerNumbers() {
        pickNumbers();
    }

    private void pickNumbers() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public int get(int i) {
        return numbers.get(i);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}

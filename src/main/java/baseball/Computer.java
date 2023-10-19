package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {

    private List<Integer> numbers;

    public List<Integer> pickNumbers() {
        while (numbers.size() < 3) {
            Integer newNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(newNumber)) {
                numbers.add(newNumber);
            }
        }
        return numbers;
    }

}

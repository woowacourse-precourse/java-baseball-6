package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Catcher {
    private List<Integer> numbers;

    public Catcher() {
        this.numbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void generateRandomNumbers() {
        numbers.clear();
        while (numbers.size() < Constant.MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}

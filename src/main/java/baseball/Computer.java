package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        makeRandomNumbers();
    }

    private void makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < Constants.NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(Constants.NUMBER_MIN, Constants.NUMBER_MAX);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}

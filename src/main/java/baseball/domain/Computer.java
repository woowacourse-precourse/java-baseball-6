package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private Numbers numbers;

    public void generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(Numbers.START_NUMBER, Numbers.END_NUMBER);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        this.numbers = new Numbers(numbers);
    }

    public Numbers getNumbers() {
        return numbers;
    }
}

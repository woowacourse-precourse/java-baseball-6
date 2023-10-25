package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    private Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Computer createRandomNumbers() {
        List<Integer> createNumbersList = new ArrayList<>();
        while (createNumbersList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!createNumbersList.contains(randomNumber)) {
                createNumbersList.add(randomNumber);
            }
        }

        return new Computer(createNumbersList);
    }

    public List<Integer> getRandomNumbers() {
        return numbers;
    }

}

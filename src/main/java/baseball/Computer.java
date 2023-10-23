package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MAX_NUMBER_LENGTH = BaseballValues.MAX_NUMBER_LENGTH.getValue();
    private static final int MIN_NUMBER = BaseballValues.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = BaseballValues.MAX_NUMBER.getValue();

    private List<Integer> numbers = new ArrayList<>();

    Computer() {
        while (this.numbers.size() < MAX_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    int[] compareNumber(List<Integer> userNumber) {

        int[] result = {0, 0};

        for (int i = 0; i < MAX_NUMBER_LENGTH; i++) {
            int myNumber = userNumber.get(i);

            for (int j = 0; j < MAX_NUMBER_LENGTH; j++) {
                int computerNumber = this.numbers.get(j);
                if (myNumber == computerNumber) {
                    if (i == j) {
                        result[0]++;
                    } else {
                        result[1]++;
                    }

                    break;
                }
            }
        }

        return result;
    }
}

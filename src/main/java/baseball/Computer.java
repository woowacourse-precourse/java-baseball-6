package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers = new ArrayList<>();

    Computer() {
        while (this.numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
    }

    Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    int[] compareNumber(List<Integer> userNumber) {

        int[] result = {0, 0};

        for (int i = 0; i < 3; i++) {
            int myNumber = userNumber.get(i);

            for (int j = 0; j < 3; j++) {
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

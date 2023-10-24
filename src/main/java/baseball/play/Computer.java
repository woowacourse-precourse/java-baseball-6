package baseball.play;

import static baseball.util.Constant.LENGTH_OF_NUMBERS;
import static baseball.util.Constant.MAX_NUM;
import static baseball.util.Constant.MIN_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        resetNumbers();
    }

    public void resetNumbers() {
        numbers = generateRandomNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < LENGTH_OF_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}

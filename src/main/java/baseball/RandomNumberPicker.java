package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberPicker {

    public List<Integer> pickDistinctNumbersInRange(int startNumber, int endNumber,
        int numberSize) {
        validateNumberRange(startNumber, endNumber);
        validateCanPickDistinctNumbers(startNumber, endNumber, numberSize);

        return getRandomNumbers(startNumber, endNumber, numberSize);
    }

    private List<Integer> getRandomNumbers(int startNumber, int endNumber,
        int numberSize) {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < numberSize) {
            int randomNumber = Randoms.pickNumberInRange(startNumber, endNumber - 1);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    private void validateNumberRange(int startNumber, int endNumber) {
        if (startNumber >= endNumber) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCanPickDistinctNumbers(int startNumber, int endNumber, int numberSize) {
        if (endNumber - startNumber < numberSize) {
            throw new IllegalArgumentException();
        }
    }
}

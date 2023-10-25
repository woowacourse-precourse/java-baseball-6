package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class NumbersManager {

    private static NumbersManager instance;
    private NumbersManager() {}

    public static NumbersManager getInstance() {
        if (instance == null) {
            instance = new NumbersManager();
        }
        return instance;
    }

    public List<Integer> setOpponentNumbers(List<Integer> numbers) {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // avoid duplicates
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public List<Integer> setUserNumbers(List<Integer> numbers, int inputNumber) {
        numbers.clear();
        while (inputNumber > 0) {
            int extractedNumber = inputNumber % 10; // extract number from 1's up to 100's
            numbers.add(extractedNumber);
            inputNumber /= 10; // remove last digit
        }

        // reverse arrange list for correct order (above logic adds 1s digit first)
        Collections.reverse(numbers);
        return numbers;
    }
}

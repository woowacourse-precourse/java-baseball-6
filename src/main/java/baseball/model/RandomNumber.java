package baseball.model;

import baseball.util.ArrayUtils;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private int[] randomNumbers;
    private final NumberValidation numberValidation = new NumberValidation();
    private final ArrayUtils arrayUtils = new ArrayUtils();

    public void generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        randomNumbers = arrayUtils.listToIntArray(numbers);
    }

    public int[] checkInputNumbers(String stringNumbers) {
        int[] inputNumbers = arrayUtils.stringToIntArray(stringNumbers);
        int[] result = numberValidation.getResult(randomNumbers, inputNumbers);
        return result;
    }
}

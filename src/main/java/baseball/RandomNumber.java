package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomNumber {
    private int[] randomNumbers;
    private final NumberValidation numberValidation = new NumberValidation();
    private final ArrayUtils arrayUtils= new ArrayUtils();

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
        int[] result = new int[2];
        int[] inputNumbers = arrayUtils.stringToIntArray(stringNumbers);
        result = numberValidation.getResult(randomNumbers, inputNumbers);
        return result;
    }
}

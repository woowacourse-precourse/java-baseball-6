package baseball.utils;

import baseball.validator.GenerateValidator;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private final GenerateValidator validator;

    public RandomGenerator() {
        this.validator = new GenerateValidator();
    }

    public int[] getRandomNumbers(int size, int startNum, int endNum) {
        validator.validateRange(size, startNum, endNum);

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = generateUniqueRandomNumber(numbers, startNum, endNum, i);
        }

        return numbers;
    }

    private int generateUniqueRandomNumber(int[] numbers, int startNum, int endNum, int currentIndex) {
        int randomNumber;
        do {
            randomNumber = Randoms.pickNumberInRange(startNum, endNum);
        } while (validator.isDuplicate(numbers, currentIndex, randomNumber));

        return randomNumber;
    }
}

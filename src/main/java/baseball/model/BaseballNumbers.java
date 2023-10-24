package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {
    public static final int NUMBERS_LENGTH = 3;
    private static final String OUT_OF_LENGTH_ERROR = "야구 숫자 길이: " + NUMBERS_LENGTH;
    private static final String DUPLICATE_NUMBER_ERROR = "야구 숫자내 중복 숫자 불가.";
    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateNumbersSize(baseballNumbers);
        validateDuplication(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateDuplication(List<BaseballNumber> baseballNumbers) {
        int distinctSize = new HashSet<>(baseballNumbers).size();
        if (distinctSize != baseballNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR);
        }
    }

    private void validateNumbersSize(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(OUT_OF_LENGTH_ERROR);
        }
    }

    public static BaseballNumbers createRandomBaseballNumbers() {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        while (baseballNumbers.size() < NUMBERS_LENGTH) {
            addUniqueRandomNumber(baseballNumbers);
        }
        return new BaseballNumbers(baseballNumbers);
    }

    private static void addUniqueRandomNumber(List<BaseballNumber> baseballNumbers) {
        BaseballNumber randomBaseballNumber = BaseballNumber.pickRandom();
        if (isUnique(baseballNumbers, randomBaseballNumber)) {
            baseballNumbers.add(randomBaseballNumber);
        }
    }

    private static boolean isUnique(List<BaseballNumber> baseballNumbers, BaseballNumber randomBaseballNumber) {
        return !baseballNumbers.contains(randomBaseballNumber);
    }

    public int size() {
        return baseballNumbers.size();
    }

    @Override
    public String toString() {
        return "BaseballNumbers{" + "baseballNumbers=" + baseballNumbers + '}';
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return new ArrayList<>(baseballNumbers);
    }
}


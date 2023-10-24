package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BaseBallNumber {

    private static final int DIGIT = 3;
    private final int[] numbers;

    private BaseBallNumber(int[] numbers) {
        validateSize(numbers);
        validateWithinRange(numbers);
        this.numbers = numbers;
    }

    public static BaseBallNumber generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return new BaseBallNumber(
                randomNumbers.stream()
                        .mapToInt(Integer::intValue)
                        .toArray());
    }

    public static BaseBallNumber generateNumber(String inputString) {

        int[] numbers = inputString.chars()
                .map(Character::getNumericValue)
                .toArray();

        return new BaseBallNumber((numbers));
    }

    public void calculate(BiConsumer<Integer,Integer> biConsumer){
        for(int i = 0; i < numbers.length; i++) {
            biConsumer.accept(numbers[i], i);
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getBaseBallNumberCount() {
        return numbers.length;
    }

    private void validateSize(int[] numbers) {
        if(numbers.length != DIGIT) throw new IllegalArgumentException("입력된 숫자는 3개로만 이루어져야 합니다.");
    }

    private void validateWithinRange(int[] numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 9) throw new IllegalArgumentException("숫자는 1 ~ 9 사이의 값만 가능합니다.");
        }
    }

}

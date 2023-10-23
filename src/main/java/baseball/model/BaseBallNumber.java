package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class BaseBallNumber {

    private final int[] numbers;

    private BaseBallNumber(int[] numbers) {
        this.numbers = numbers;
    }

    public static BaseBallNumber generateRandomNumbers(int digit) {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < digit) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return new BaseBallNumber(
                randomNumbers.stream().mapToInt(Integer::intValue).toArray());
    }

    public static BaseBallNumber parse(String inputString) {

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

}

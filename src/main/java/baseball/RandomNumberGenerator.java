package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private final List<Integer> numbers;

    private RandomNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static RandomNumberGenerator generateThreeDigits() {

        List<Integer> generatedDigits = new ArrayList<>();

        while (generatedDigits.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!generatedDigits.contains(randomNumber)) {
                generatedDigits.add(randomNumber);
            }
        }

        return new RandomNumberGenerator(generatedDigits);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}

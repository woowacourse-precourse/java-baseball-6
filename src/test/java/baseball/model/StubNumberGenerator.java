package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StubNumberGenerator implements NumberGenerator {

    private final int numbers;

    public StubNumberGenerator(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> numberList = new ArrayList<>();
        String numberToString = String.valueOf(numbers);

        Arrays.stream(numberToString.split(""))
            .map(Integer::parseInt)
            .forEach(numberList::add);

        return numberList;
    }
}

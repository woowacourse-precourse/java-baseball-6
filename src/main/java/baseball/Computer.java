package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Computer {
    private static final int LOWER_NUMBER_RANGE = 1;
    private static final int UPPER_NUMBER_RANGE = 3;

    public Baseballs createComputerNumbers(final NumberCreator numberCreator) {
        List<Integer> numbers = IntStream.rangeClosed(LOWER_NUMBER_RANGE, UPPER_NUMBER_RANGE)
                .map(number -> numberCreator.create())
                .boxed()
                .toList();

        return new Baseballs(numbers);
    }
}

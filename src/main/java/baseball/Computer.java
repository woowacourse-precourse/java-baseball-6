package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MAX_SIZE = 3;

    public static Baseballs createComputerNumbers(final NumberCreator numberCreator) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_SIZE) {
            int randomNumber = numberCreator.create();
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Baseballs(numbers);
    }
}

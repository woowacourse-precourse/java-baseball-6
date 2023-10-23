package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MAX_SIZE = 3;

    private final NumberCreator numberCreator;

    public Computer(final NumberCreator numberCreator) {
        this.numberCreator = numberCreator;
    }

    public Baseballs createComputerNumbers() {
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

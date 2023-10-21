package model.player;

import java.util.List;

public class Computer extends Player {

    private Computer(List<Integer> numbers) {
        super(numbers);
    }

    public static Computer create(List<Integer> numbers) {
        return new Computer(numbers);
    }

    public boolean isContainsNumber(int numberByPosition) {
        return numbers.contains(numberByPosition);
    }
}

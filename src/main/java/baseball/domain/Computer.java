package baseball.domain;

import baseball.utils.NumberGenerator;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer(NumberGenerator numberGenerator) {
        this.numbers = numberGenerator.generate();
        System.out.println(numbers);
    }

    public int compareSameIndexNumber(Player player) {
        return (int) numbers.stream()
                .filter(number -> player.isEquals(number, numbers.indexOf(number)))
                .count();
    }

    public int compareContainNumber(Player player) {
        return (int) numbers.stream()
                .filter(player::isContain)
                .count();
    }
}

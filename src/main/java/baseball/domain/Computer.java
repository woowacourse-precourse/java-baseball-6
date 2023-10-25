package baseball.domain;

import baseball.utils.NumberGenerator;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer(NumberGenerator numberGenerator) {
        this.numbers = numberGenerator.generate();
    }

    public int countSameIndexNumber(Player player) {
        return (int) numbers.stream()
                .filter(number -> player.isSameIndex(number, numbers.indexOf(number)))
                .count();
    }

    public int countContainNumber(Player player) {
        return (int) numbers.stream()
                .filter(player::isContain)
                .count();
    }
}

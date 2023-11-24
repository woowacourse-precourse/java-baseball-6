package baseball.model;

import java.util.List;

public class Computer {

    private final List<Integer> numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int countSameNumber(Player player) {
        return (int) numbers.stream()
                .filter(player::hasNumber)
                .count();
    }

    public int countSamePlace(Player player) {
        return (int) numbers.stream()
                .filter(number -> player.hasSamePlace(number, numbers.indexOf(number)))
                .count();
    }
}

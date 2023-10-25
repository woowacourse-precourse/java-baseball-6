package baseball.domain;

import baseball.utils.NumberGenerator;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer(NumberGenerator numberGenerator) {
        this.numbers = numberGenerator.generate();
        System.out.println(numbers);
    }

    public Boolean compareStrike(Player player, int idx) {
        int playerNumber = player.getNumber(idx);
        return numbers.get(idx).equals(playerNumber);
    }

    public Boolean compareBall(Player player, int idx) {
        int playerNumber = player.getNumber(idx);
        return numbers.contains(playerNumber) && !numbers.get(idx).equals(playerNumber);
    }
}

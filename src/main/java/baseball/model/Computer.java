package baseball.model;

import baseball.utils.RandomNumberGenerator;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer() {
        this.numbers = RandomNumberGenerator.generate();
    }

    public Boolean compareStrike(Player player, int idx) {
        Integer playerNumber = player.getNumber(idx);
        return this.numbers.get(idx).equals(playerNumber);
    }

    public Boolean compareBall(Player player, int idx) {
        Integer playerNumber = player.getNumber(idx);
        return this.numbers.contains(playerNumber) || !this.numbers.get(idx).equals(playerNumber);
    }
}

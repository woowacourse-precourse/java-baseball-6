package baseball.domain;

import baseball.utils.NumberGenerator;
import java.util.List;

public class Computer {
    private final List<Integer> numbers;

    public Computer(NumberGenerator numberGenerator) {
        this.numbers = numberGenerator.generate();
    }

    public Boolean compareStrike(Player player, int idx) {
        Integer playerNumber = player.getNumber(idx);
        return this.numbers.get(idx).equals(playerNumber);
    }

    public Boolean compareBall(Player player, int idx) {
        Integer playerNumber = player.getNumber(idx);
        return this.numbers.contains(playerNumber) && !this.numbers.get(idx).equals(playerNumber);
    }

    public Computer resetOrMaintain(GameState state, NumberGenerator numberGenerator) {
        if (state.isRetry()) {
            return new Computer(numberGenerator);
        }
        return this;
    }
}

package baseball.domain.game;

import baseball.util.NumberGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ComputerNumberGenerator {
    private final NumberGenerator numberGenerator;

    public ComputerNumberGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Computer create() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < GameNumbers.GAME_NUMBERS_COUNT) {
            set.add(numberGenerator.createNumber());
        }
        return Computer.of(new ArrayList<>(set));
    }
}

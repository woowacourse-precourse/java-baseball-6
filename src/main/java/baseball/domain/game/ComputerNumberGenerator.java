package baseball.domain.game;

import baseball.refactoring.BallNumbersValidator;
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
        while (set.size() < BallNumbersValidator.GAME_NUMBERS_SIZE) {
            set.add(numberGenerator.createNumber());
        }
        return Computer.of(new ArrayList<>(set));
    }
}

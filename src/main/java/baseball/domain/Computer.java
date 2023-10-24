package baseball.domain;

import baseball.util.RandomGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private static final int CAPACITY = 3;

    private final List<Baseball> baseballs = new ArrayList<>();

    public List<Baseball> generateBaseball() {
        if (!baseballs.isEmpty()) {
            baseballs.clear();
        }

        while (this.baseballs.size() != CAPACITY) {
            Baseball baseball = new Baseball(RandomGenerator.generateNumber());
            if (!isDuplicatedBaseball(baseball)) {
                this.baseballs.add(baseball);
            }
        }

        return this.baseballs;
    }

    private boolean isDuplicatedBaseball(Baseball baseball) {
        if (this.baseballs.contains(baseball)) {
            return true;
        }
        return false;
    }

    public List<Integer> numbersOfBaseballs() {
        return this.baseballs.stream().map(baseball -> baseball.getNumber()).collect(Collectors.toList());
    }

}

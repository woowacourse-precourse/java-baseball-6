package baseball.domain.ball;

import collection.Triple;
import java.util.LinkedHashSet;
import java.util.Set;
import number.NumberPicker;

public final class AnswerCreator {

    private final NumberPicker numberPicker;

    public AnswerCreator(final NumberPicker numberPicker) {
        this.numberPicker = numberPicker;
    }

    public Answer create() {
        final Set<BallNumber> numbers = fillUntilHasThreeBallNumbers(new LinkedHashSet<>());
        final Triple<BallNumber> triple = Triple.fromSet(numbers);
        return Answer.of(triple);
    }

    private Set<BallNumber> fillUntilHasThreeBallNumbers(final Set<BallNumber> set) {
        if (set.size() == BallNumbers.BALL_COUNT) {
            return set;
        }
        set.add(new BallNumber(numberPicker.pick()));
        return fillUntilHasThreeBallNumbers(set);
    }
}

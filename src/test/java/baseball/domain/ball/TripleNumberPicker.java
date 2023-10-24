package baseball.domain.ball;

import java.util.LinkedList;
import java.util.Queue;
import number.NumberPicker;

public final class TripleNumberPicker implements NumberPicker {

    private final Queue<Integer> numbers;

    public TripleNumberPicker(
            final int first,
            final int second,
            final int third
    ) {
        this.numbers = new LinkedList<>();
        numbers.add(first);
        numbers.add(second);
        numbers.add(third);
    }

    @Override
    public int pick() {
        return numbers.remove();
    }
}

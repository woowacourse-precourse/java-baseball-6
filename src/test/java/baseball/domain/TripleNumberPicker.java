package baseball.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import number.NumberPicker;

public final class TripleNumberPicker implements NumberPicker {

    private final Queue<Integer> numbers;

    public TripleNumberPicker(
            final int first,
            final int second,
            final int third
    ) {
        this.numbers = new LinkedList<>(List.of(first, second, third));
    }

    @Override
    public int pick() {
        return numbers.remove();
    }
}

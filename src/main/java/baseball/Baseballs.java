package baseball;

import java.util.List;

public class Baseballs {
    private final List<Baseball> baseballs;

    public Baseballs(final List<Integer> numbers) {
        validateSize(numbers);
        this.baseballs = null;
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalStateException("3자리 수가 아닙니다.");
        }
    }

}

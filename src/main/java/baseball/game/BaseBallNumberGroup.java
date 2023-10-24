package baseball.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class BaseBallNumberGroup {
    private final List<Integer> baseBallNumbers;

    public BaseBallNumberGroup(final List<Integer> baseBallNumbers) {
        validateSize(baseBallNumbers);
        validateDuplicate(baseBallNumbers);
        this.baseBallNumbers = baseBallNumbers;
    }

    private void validateSize(final List<Integer> baseBallNumbers) {
        if (baseBallNumbers.size() != GameConstants.SIZE_RANDOM_NUMBER) {
            throw new IllegalArgumentException("숫자 야구 개수는 3개만 가능합니다.");
        }
    }

    private void validateDuplicate(final List<Integer> baseBallNumbers) {
        final Set<Integer> nonDuplicateNumbers = new HashSet<>(baseBallNumbers);
        if (nonDuplicateNumbers.size() != GameConstants.SIZE_RANDOM_NUMBER) {
            throw new IllegalArgumentException("숫자 야구는 서로 중복될 수 없습니다.");
        }
    }

    public int get(final int index) {
        return baseBallNumbers.get(index);
    }

    public Stream<Integer> stream() {
        return baseBallNumbers.stream();
    }

}

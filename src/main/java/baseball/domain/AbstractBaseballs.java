package baseball.domain;

import java.util.List;

abstract class AbstractBaseballs {
    protected static final int BASEBALLS_SIZE = 3;

    protected final List<Baseball> baseballs;

    protected AbstractBaseballs(List<Baseball> baseballs) {
        validateSizeExact(baseballs);
        validateNoDuplicate(baseballs);
        this.baseballs = baseballs;
    }

    private void validateSizeExact(List<Baseball> baseballs) {
        if (baseballs.size() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicate(List<Baseball> baseballs) {
        if (baseballs.stream().distinct().count() != BASEBALLS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}

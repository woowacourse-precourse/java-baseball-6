package baseball.model.generator;

import java.util.List;


public abstract class NumberGenerator {
    protected static final Integer NUMBER_MIN_RANGE = 1;
    protected static final Integer NUMBER_MAX_RANGE = 9;

    protected static final Integer LIST_SIZE = 3;

    public abstract List<Integer> generateList();

    protected abstract List<Integer> convertToList();
}

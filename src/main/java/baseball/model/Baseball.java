package baseball.model;

import baseball.validator.BaseballValidator;
import java.util.Collection;
import java.util.List;

public class Baseball {

    public static final int LENGTH = 3;

    private final List<BaseballNumber> baseballNumbers;

    private Baseball(Collection<Integer> baseballNumbers) {
        this.baseballNumbers = baseballNumbers.stream()
                .map(BaseballNumber::new)
                .toList();
    }

    public static Baseball from(Collection<Integer> baseballNumbers) {
        BaseballValidator.validateLength(baseballNumbers);
        BaseballValidator.validateUnique(baseballNumbers);

        return new Baseball(baseballNumbers);
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return baseballNumbers;
    }
}

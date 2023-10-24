package baseball.model;

import baseball.validator.BaseballValidator;
import java.util.List;

public class Baseball {

    public static final int LENGTH = 3;

    private final List<BaseballNumber> baseballNumbers;

    private Baseball(List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers.stream().toList();
    }

    public static Baseball from(List<BaseballNumber> baseballNumbers) {
        BaseballValidator.validate(baseballNumbers);

        return new Baseball(baseballNumbers);
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return baseballNumbers;
    }

    public BaseballGameResult match(final Baseball compare) {
        BaseballGameResult result = new BaseballGameResult();

        List<BaseballNumber> compareNumbers = compare.getBaseballNumbers();
        for (int i = 0; i < Baseball.LENGTH; i++) {
            BaseballNumber number = baseballNumbers.get(i);
            BaseballNumber compareNumber = compareNumbers.get(i);

            addResult(result, number, compareNumber);
        }

        return result;
    }

    private void addResult(BaseballGameResult result, BaseballNumber number, BaseballNumber compareNumber) {
        if (isStrike(number, compareNumber)) {
            result.add(BaseballGameResultType.STRIKE);
        } else if (isBall(compareNumber)) {
            result.add(BaseballGameResultType.BALL);
        }
    }

    private boolean isStrike(BaseballNumber number, BaseballNumber compareNumber) {
        return number.equals(compareNumber);
    }

    private boolean isBall(BaseballNumber compareNumber) {
        return baseballNumbers.contains(compareNumber);
    }

    @Override
    public String toString() {
        return "Baseball" + baseballNumbers;
    }
}

package baseball.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseballNumbers {
    public static final int BASEBALL_NUMBERS_COUNT = 3;

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validation(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public static BaseballNumbers from(List<BaseballNumber> baseballNumbers) {
        return new BaseballNumbers(baseballNumbers);
    }

    private void validation(List<BaseballNumber> baseballNumbers) {
        if(baseballNumbers.size() != BASEBALL_NUMBERS_COUNT) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
        if(baseballNumbers.stream()
                .map(BaseballNumber::getBaseballNumber)
                .distinct()
                .count() != BASEBALL_NUMBERS_COUNT) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return this.baseballNumbers;
    }

    public List<String> matchNumbersIndex(BaseballNumbers targetNumbers) {
        AtomicInteger counter = new AtomicInteger(0);
        return targetNumbers.getBaseballNumbers()
                .stream()
                .map(targetNumber -> targetNumber.matchIndex(baseballNumbers))
                .map(targetIndex -> matchResult(targetIndex, counter.getAndIncrement()))
                .filter(result -> !result.equals("낫싱"))
                .collect(Collectors.toList());
    }

    private String matchResult(int targetIndex, int matchIndex) {
        if(targetIndex == -1) {
            return "낫싱";
        }
        if(targetIndex == matchIndex) {
            return "스트라이크";
        }
        return "볼";
    }
}
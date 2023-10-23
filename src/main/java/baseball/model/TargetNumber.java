package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TargetNumber {
    private final List<BaseballNumber> baseballNumbers;

    private TargetNumber(final List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static TargetNumber randomInstance(final int size) {
        List<BaseballNumber> uniqueBaseballNumbers = new ArrayList<>();

        while (uniqueBaseballNumbers.size() < size) {
            BaseballNumber randomBaseballNumber = BaseballNumber.createRandomNumber();

            if (uniqueBaseballNumbers.contains(randomBaseballNumber)) {
                continue;
            }

            uniqueBaseballNumbers.add(randomBaseballNumber);
        }

        return new TargetNumber(Collections.unmodifiableList(uniqueBaseballNumbers));
    }

    public GameResult calculateGameResult(final List<Integer> inputPlayerNumbers) {
        List<BaseballNumber> userBaseballNumbers = convertInputValueToBaseballNumbers(inputPlayerNumbers);

        if (baseballNumbers.size() != userBaseballNumbers.size()) {
            throw new IllegalArgumentException();
        }

        return createGameResult(userBaseballNumbers);
    }

    private List<BaseballNumber> convertInputValueToBaseballNumbers(final List<Integer> playerNumbers) {
        verifyDuplicates(playerNumbers);

        return playerNumbers.stream()
                .map(BaseballNumber::new)
                .toList();
    }

    private void verifyDuplicates(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private GameResult createGameResult(List<BaseballNumber> userBaseballNumbers) {
        int correctCount = 0;
        int similarCount = 0;

        for (int i = 0; i < baseballNumbers.size(); i++) {
            BaseballNumber computerBaseballNumber = baseballNumbers.get(i);
            BaseballNumber userBaseballNumber = userBaseballNumbers.get(i);

            if (computerBaseballNumber.equals(userBaseballNumber)) {
                correctCount++;
                continue;
            }

            if (baseballNumbers.contains(userBaseballNumber)) {
                similarCount++;
            }
        }

        return new GameResult(correctCount, similarCount);
    }
}

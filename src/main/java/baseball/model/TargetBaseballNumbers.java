package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TargetBaseballNumbers {
    public static final int BASEBALL_NUMBER_SIZE = 3;
    private final List<BaseballNumber> baseballNumbers;

    private TargetBaseballNumbers(final List<BaseballNumber> baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public static TargetBaseballNumbers randomInstance() {
        List<BaseballNumber> uniqueBaseballNumbers = new ArrayList<>();

        while (uniqueBaseballNumbers.size() < BASEBALL_NUMBER_SIZE) {
            BaseballNumber randomBaseballNumber = BaseballNumber.createRandomNumber();

            if (uniqueBaseballNumbers.contains(randomBaseballNumber)) {
                continue;
            }

            uniqueBaseballNumbers.add(randomBaseballNumber);
        }

        return new TargetBaseballNumbers(Collections.unmodifiableList(uniqueBaseballNumbers));
    }

    public GameResult calculateGameResult(final List<Integer> inputNumbers) {
        List<BaseballNumber> playerBaseballNumbers = convertInputToBaseballNumbers(inputNumbers);
        return createGameResult(playerBaseballNumbers);
    }

    private List<BaseballNumber> convertInputToBaseballNumbers(final List<Integer> inputNumbers) {
        verifyInputNumberSize(inputNumbers);
        verifyDuplicates(inputNumbers);

        return inputNumbers.stream()
                .map(BaseballNumber::new)
                .toList();
    }

    private void verifyInputNumberSize(final List<Integer> inputNumbers) {
        if (TargetBaseballNumbers.BASEBALL_NUMBER_SIZE != inputNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyDuplicates(final List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);

        if (uniqueNumbers.size() != inputNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private GameResult createGameResult(List<BaseballNumber> playerBaseballNumbers) {
        int correctCount = 0;
        int similarCount = 0;

        for (int i = 0; i < baseballNumbers.size(); i++) {
            BaseballNumber computerBaseballNumber = baseballNumbers.get(i);
            BaseballNumber playerBaseballNumber = playerBaseballNumbers.get(i);

            if (computerBaseballNumber.equals(playerBaseballNumber)) {
                correctCount++;
                continue;
            }

            if (baseballNumbers.contains(playerBaseballNumber)) {
                similarCount++;
            }
        }

        return new GameResult(BASEBALL_NUMBER_SIZE, correctCount, similarCount);
    }
}

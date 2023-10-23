package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TargetNumber {
    private final List<Number> numbers;

    private TargetNumber(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public static TargetNumber randomInstance(final int size) {
        List<Number> uniqueNumbers = new ArrayList<>();

        while (uniqueNumbers.size() < size) {
            Number randomNumber = Number.createRandomNumber();

            if (uniqueNumbers.contains(randomNumber)) {
                continue;
            }

            uniqueNumbers.add(randomNumber);
        }

        return new TargetNumber(Collections.unmodifiableList(uniqueNumbers));
    }

    public GameResult calculateGameResult(final List<Integer> inputPlayerNumbers) {
        List<Number> userNumbers = convertInputValueToBaseballNumbers(inputPlayerNumbers);

        if (numbers.size() != userNumbers.size()) {
            throw new IllegalArgumentException();
        }

        return createGameResult(userNumbers);
    }

    private List<Number> convertInputValueToBaseballNumbers(final List<Integer> playerNumbers) {
        verifyDuplicates(playerNumbers);

        return playerNumbers.stream()
                .map(Number::new)
                .toList();
    }

    private void verifyDuplicates(final List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private GameResult createGameResult(List<Number> userNumbers) {
        int correctCount = 0;
        int similarCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            Number computerNumber = numbers.get(i);
            Number userNumber = userNumbers.get(i);

            if (computerNumber.equals(userNumber)) {
                correctCount++;
                continue;
            }

            if (numbers.contains(userNumber)) {
                similarCount++;
            }
        }

        return new GameResult(correctCount, similarCount);
    }
}

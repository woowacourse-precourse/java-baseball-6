package baseball.domain;

import baseball.util.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BallNumbers {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private List<Integer> numberList = new ArrayList<>();

    public List<Integer> generateBaseball() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            int number = randomNumberGenerator.generate();
            numbers.add(number);
        }

        numberList = numbers.stream().toList();
        return numberList;
    }

    public List<Integer> compareNumbers(final List<Integer> inputNumbers) {
        List<Integer> matchedNumbers = matchNumbers(inputNumbers);

        if (!matchedNumbers.isEmpty()) {
            return matchPosition(matchedNumbers, inputNumbers);
        }

        return List.of(0, 0);
    }

    private List<Integer> matchNumbers(final List<Integer> inputNumbers) {
        return numberList.stream().filter(inputNumbers::contains).collect(Collectors.toList());
    }

    private List<Integer> matchPosition(final List<Integer> matchedNumbers,
                                        final List<Integer> inputNumbersList) {
        List<Integer> result = new ArrayList<>();
        int strike = 0;
        int ball = 0;

        for (Integer matchedNumber : matchedNumbers) {
            if (numberList.indexOf(matchedNumber) == inputNumbersList.indexOf(matchedNumber)) {
                strike++;
                continue;
            }
            ball++;
        }

        result.add(strike);
        result.add(ball);

        return result;
    }
}

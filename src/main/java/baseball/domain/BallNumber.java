package baseball.domain;

import baseball.util.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumber {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private List<Integer> numberList = new ArrayList<>();

    /**
     * 랜덤한 숫자 3개 뽑음
     */
    public List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            int number = randomNumberGenerator.generate();
            numbers.add(number);
        }

        numberList = numbers.stream().toList();
        return numberList;
    }
}

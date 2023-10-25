package baseball.utility;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.configuration.RandomNumberConfig.*;

public class RandomNumberGenerator {

    public static List<Integer> generateNotDuplicatedRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            numbers.add(randomNumber);
        }

        return numbers.stream().toList();
    }

}

package baseball.util;

import baseball.ball.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomUniqueNumber {
    public static List<Integer> getRandomUniqueNumbers(int size) {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(Number.MINIMUM_NUMBER, Number.MAXIMUM_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return new ArrayList<>(numbers);
    }
}

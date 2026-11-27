package baseball.generator;

import baseball.domain.BaseballRules;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < BaseballRules.NUMBER_COUNT) {
            int number = Randoms.pickNumberInRange(
                    BaseballRules.MIN_NUMBER,
                    BaseballRules.MAX_NUMBER
            );

            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return numbers;
    }
}

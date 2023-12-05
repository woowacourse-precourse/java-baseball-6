package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.global.Constants.*;

public class NumbersGenerator {
    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != NUMBERS_SIZE) {
            int number = Randoms.pickNumberInRange(START_NUMBER_INDEX, END_NUMBER_INDEX);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}

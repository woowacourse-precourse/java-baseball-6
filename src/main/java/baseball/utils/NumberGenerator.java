package baseball.utils;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_LENGTH) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return numbers;
    }
}

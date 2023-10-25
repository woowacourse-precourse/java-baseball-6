package baseball;


import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> generateRandom(int count) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < count) {
            int randomNumber = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
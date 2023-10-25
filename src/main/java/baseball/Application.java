package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int NUM_DIGITS = 3;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUM_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {

    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MAX_NUM = 9;
    private static final int NUM_SIZE = 3;

    public static void main(String[] args) {

    }
    private static List<Integer> makeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, MAX_NUM);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }


}

package baseball.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static List<Integer> generateRandomNumber(int length) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
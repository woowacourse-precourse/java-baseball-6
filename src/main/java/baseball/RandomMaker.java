package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomMaker {
    public static List<Character> makeRandomNumbers() {
        List<Character> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            Character number = (char) (Randoms.pickNumberInRange(1, 9) + '0');
            
            numbers.add(number);
        }

        return numbers;
    }
}

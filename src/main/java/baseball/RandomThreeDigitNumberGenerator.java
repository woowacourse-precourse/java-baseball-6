package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomThreeDigitNumberGenerator {


    public static List<Integer> generateRandomThreeNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomDigitNumber = Randoms.pickNumberInRange(1, 9) ;
            if (numbers.contains(randomDigitNumber)) {
                --i;
                continue;
            }
            numbers.add(randomDigitNumber);
        }
        return numbers;
    }

}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> generateComputerRandomNumber(int length) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        List<Integer> computerRandomNumber = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }
        return computerRandomNumber;
    }
}

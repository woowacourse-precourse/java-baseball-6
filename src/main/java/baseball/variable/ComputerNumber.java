package baseball.variable;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class ComputerNumber {
    public List<Integer> setComputerNumber(List<Integer> number) {
        while (number.size() < 3) {
            int randomNumber = getRandomNumber(number);
            number.add(randomNumber);
        }
        return number;
    }

    private int getRandomNumber(List<Integer> number) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!number.contains(randomNumber)) {
            return randomNumber;
        }
        return getRandomNumber(number);
    }
}

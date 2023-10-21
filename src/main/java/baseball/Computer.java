package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> number = new ArrayList<>();
    Computer() {
        createRandomNumber();
    }

    public List<Integer> createRandomNumber() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        number = result;
        System.out.println(number);
        return result;
    }

    public void resetNumber() {
        number.clear();
        createRandomNumber();
    }
}

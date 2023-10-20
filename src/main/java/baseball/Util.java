package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<Integer> getRandomNumber() {

        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return numbers;
    }
}

package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> generateRandomNumber() {
        List<Integer> computeNumber = new ArrayList<>();
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (computeNumber.size() < 3) {
            if (!computeNumber.contains(randomNumber)) {
                computeNumber.add(randomNumber);
            }
        }
        return computeNumber;
    }

}

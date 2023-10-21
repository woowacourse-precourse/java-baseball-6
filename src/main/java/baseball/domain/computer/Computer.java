package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(pickedNumber)) {
                randomNumber.add(pickedNumber);
            }
        }
        return randomNumber;
    }
}

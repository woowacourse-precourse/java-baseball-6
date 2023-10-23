package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Computer implements Player {
    @Override
    public List<Integer> getNumber() {
        return number;
    }

    public void setRandomNumber() {
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

}

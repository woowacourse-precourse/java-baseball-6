package baseball.util;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGenerator implements RandomNumGenerator{

    @Override
    public List<Integer> getRandomNumber() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < Constants.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
        return randomNums;
    }
}

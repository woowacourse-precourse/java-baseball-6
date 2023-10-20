package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
public class ValidNumberPicker {
    public int pickValidNumber(List<Integer> validBallsList) {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if (validBallsList.contains(randomNumber)){
            return pickValidNumber(validBallsList);
        }
        return randomNumber;
    }
}

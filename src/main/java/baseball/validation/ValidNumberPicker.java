package baseball.validation;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
public class ValidNumberPicker {
    private final Integer rangeStartNumber = 1;
    private final Integer rangeEndNumber = 9;
    public int pickValidNumber(List<Integer> validBallsList) {
        int randomNumber = Randoms.pickNumberInRange(rangeStartNumber,rangeEndNumber);
        if (validBallsList.contains(randomNumber)){
            return pickValidNumber(validBallsList);
        }
        return randomNumber;
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class ValidRandomBallsList {
    private Integer MAX_CAPACITY = 3;
    List<Integer> validBallsList = new ArrayList<>();
    public List<Integer> createValidRandomBallsList() {
        int randomNumber = new ValidNumberPicker().pickValidNumber(validBallsList);
        validBallsList.add(randomNumber);
        if (validBallsList.size() != MAX_CAPACITY) {
            return createValidRandomBallsList();
        }
        return validBallsList;
    }
}

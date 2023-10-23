package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {

    List<Integer> computerNumberList = new ArrayList<>();

    public List<Integer> getAnswerNumberList() {
        while (computerNumberList.size() < Constants.NUMBER_SIZE) {
            int singleDigitNumber = Randoms.pickNumberInRange(Constants.MIN_RANGE_NUM,
                Constants.MAX_RANGE_NUM);
            if (!computerNumberList.contains(singleDigitNumber)) {
                computerNumberList.add(singleDigitNumber);
            }
        }
        return computerNumberList;
    }

}

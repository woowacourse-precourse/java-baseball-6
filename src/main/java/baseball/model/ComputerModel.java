package baseball.model;

import baseball.util.common.Common;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerModel {

    private static final List<Integer> splitDigitsFromRandomNumber = new ArrayList<>();

    /**
     * 배열 초기화 새로운 랜덤 번호 배열에 넣는다.
     */
    public void initNumber() {
        splitDigitsFromRandomNumber.clear();
        while (splitDigitsFromRandomNumber.size() < Common.NUM_LENGTH) {
            //여기서 IllegalArgumentException 고려해봐야 한다.
            int randomNumber = Randoms.pickNumberInRange(Common.START_INCLUSIVE,
                    Common.END_INCLUSIVE);
            if (!splitDigitsFromRandomNumber.contains(randomNumber)) {
                splitDigitsFromRandomNumber.add(randomNumber);
            }
        }
    }

    public Integer getSplitDigitFromRandomNumber(int trackIdx){
        return splitDigitsFromRandomNumber.get(trackIdx);
    }

    public boolean hasContainNumber(int digit){
        return splitDigitsFromRandomNumber.contains(digit);
    }
}

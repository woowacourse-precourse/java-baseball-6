package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    //리스트에 랜덤한 중복되지 않은 숫자를 저장한 후 리스트 반환
    public static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NumberLimits.NUM_LIST_LENGTH.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(NumberLimits.MIN_VALUE.getValue(),
                    NumberLimits.MAX_VALUE.getValue());
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
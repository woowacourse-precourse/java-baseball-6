package baseball.model;

import baseball.ConstantVO;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumber {
    public int generateRandom() {
        return Randoms.pickNumberInRange(ConstantVO.START_NUMBER, ConstantVO.END_NUMBER);
    }

    public List<Integer> create() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < ConstantVO.SIZE) {
            int randomNumber = generateRandom();
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}

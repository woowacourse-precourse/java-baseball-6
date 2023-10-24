package baseball.domain;

import static baseball.consts.NumberConst.END_NUMBER;
import static baseball.consts.NumberConst.NUMBER_SIZE;
import static baseball.consts.NumberConst.START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNum {

    public List<Integer> buildComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < Constant.INPUT_LENGTH) {
            int randomNum = Randoms.pickNumberInRange(Constant.START_RANGE,Constant.END_RANGE);
            if (!computerNumbers.contains(randomNum)) {
                computerNumbers.add(randomNum);
            }
        }
        return computerNumbers;
    }
}
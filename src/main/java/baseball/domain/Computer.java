package baseball.domain;

import java.util.List;
import java.util.ArrayList;

import baseball.utils.Constants;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> computerNumbers;

    public List<Integer> getComputerNumber(){
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < Constants.MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(Constants.MIN_NUM_RANGE, Constants.MAX_NUM_RANGE);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}

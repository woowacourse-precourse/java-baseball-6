package baseball.service;

import static baseball.common.Constants.END_GAME;
import static baseball.common.Constants.NUMBER_LENGTH;
import static baseball.common.Constants.RESTART;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class SystemService {

    public List<Integer> generateComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    public boolean restart(String userInput) {

        if (userInput.equals(RESTART)) {
            return true;
        } else if (userInput.equals(END_GAME)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}

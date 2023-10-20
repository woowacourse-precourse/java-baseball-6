package baseball.service;

import baseball.domain.UserBaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {

    public void compareNumber(UserBaseballNumber userBaseballNumber) {

    }

    private List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}

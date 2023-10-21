package baseball.service;

import baseball.domain.UserBaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {

    public void compareNumber(UserBaseballNumber userBaseballNumber) {
        List<Integer> computer = getComputerNumbers();
        int strike = 0, ball = 0;

        while (true) {
            List<Integer> userNumbers = userBaseballNumber.getUserValues();

            for (int i = 0; i < userNumbers.size(); i++) {
                if (userNumbers.get(i) == computer.get(i)) {
                    strike += 1;
                } else if (computer.contains(userNumbers.get(i))) {
                    ball += 1;
                }
            }

            if (strike == 3) {
                break;
            }
        }
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

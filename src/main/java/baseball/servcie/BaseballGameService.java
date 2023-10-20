package baseball.servcie;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {


    public List<Integer> initComputerBaseBallNumber() {

        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        return computerNumberList;
    }
}

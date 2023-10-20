package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {

    GameService() {
    }

    public List<Integer> makeRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumberInt = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumberInt)) {
                randomNumberList.add(randomNumberInt);
            }
        }
        return randomNumberList;
    }
}

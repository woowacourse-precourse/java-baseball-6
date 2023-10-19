package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.GameConstant.*;

public class Game {
    List<Integer> randomNumberList = new ArrayList<>();

    private void createRandomNumber(){
        randomNumberList.clear();
        while (randomNumberList.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE, LAST_RANGE);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
    }


}

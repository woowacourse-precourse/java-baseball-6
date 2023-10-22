package baseball.controller;

import baseball.domain.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public static List<Integer> generateRandomBaseball() {
        List<Integer> computerNumList = new ArrayList<>();
        while (computerNumList.size() < GameConstants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);
            if (!computerNumList.contains(randomNumber)) {
                computerNumList.add(randomNumber);
            }
        }

        return computerNumList;
    }
}

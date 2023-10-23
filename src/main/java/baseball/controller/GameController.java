package baseball.controller;

import baseball.domain.GameConstants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private StartView startView;

    public GameController(StartView startView) {
        this.startView = startView;
    }

    public List<Integer> generateRandomBaseball() {
        List<Integer> computerList = new ArrayList<>();
        while (computerList.size() < GameConstants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber);
            }
        }

        return computerList;
    }


}

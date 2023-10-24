package baseball.controller;

import baseball.controller.hint.HintController;
import baseball.controller.hint.StrikeController;
import baseball.domain.Baseball;
import baseball.domain.GameConstants;
import baseball.domain.Restart;
import baseball.domain.hint.Hint;
import baseball.domain.hint.Strike;
import baseball.util.ExceptionUtil;
import baseball.util.InputUtil;
import baseball.util.IntegerListUtil;
import baseball.util.IntegerUtil;
import baseball.view.*;


public class GameController {

    private StartView startView;
    private InputView inputView;
    private HintView hintView;

    public GameController(StartView startView, InputView inputView, HintView hintView) {
        this.startView = startView;
        this.inputView = inputView;
        this.hintView = hintView;
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

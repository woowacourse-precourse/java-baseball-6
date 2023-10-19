package baseball.application;

import baseball.entity.NumberBaseball;
import baseball.utils.InputUtil;

public class BaseballGameService {

    public void startGame() {
        NumberBaseball userNumberBaseball = new NumberBaseball();
        String guessNumber = InputUtil.requireGuessNumber();

    }
}

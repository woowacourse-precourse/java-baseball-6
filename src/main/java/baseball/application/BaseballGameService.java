package baseball.application;

import baseball.entity.Baseball;
import baseball.utils.InputUtil;

public class BaseballGameService {

    public void startGame() {
        Baseball userNumberBaseball = new Baseball();
        String guessNumber = InputUtil.requireGuessNumber();

    }
}

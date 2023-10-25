package baseball;

import baseball.domain.BaseballComputer;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballUser;
import baseball.domain.Game;
import baseball.policy.BaseballJudgmentPolicy;
import baseball.policy.BaseballValidationPolicy;

public class Application {
    public static void main(String[] args) {

        Game game = new BaseballGame(new BaseballComputer(), new BaseballUser(new BaseballValidationPolicy()),
                new BaseballJudgmentPolicy());
        game.start();
    }


}

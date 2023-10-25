package baseball;

import baseball.domain.BaseballComputer;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballUser;
import baseball.domain.Game;
import baseball.policy.JudgmentPolicy;
import baseball.policy.ValidationPolicy;

public class Application {
    public static void main(String[] args) {

        Game game = new BaseballGame(new BaseballComputer(), new BaseballUser(new ValidationPolicy()),
                new JudgmentPolicy());
        game.start();
    }


}

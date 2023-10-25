package baseball;

import baseball.domain.BaseballComputer;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballUser;
import baseball.domain.Game;
import baseball.policy.JudgmentPolicy;

public class Application {
    public static void main(String[] args) {

        Game game = new BaseballGame(new BaseballComputer(), new BaseballUser(), new JudgmentPolicy());
        game.start();
    }







}

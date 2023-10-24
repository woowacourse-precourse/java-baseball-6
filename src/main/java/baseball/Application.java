package baseball;


import baseball.domain.BaseBallGame;
import baseball.domain.Player;

import static baseball.util.ConstMessages.START_MESSAGE;

public class Application {
    public static void main(String[] args)  {

        BaseBallGame baseBallGame = new BaseBallGame(new Player());
        baseBallGame.startGame();

    }
}

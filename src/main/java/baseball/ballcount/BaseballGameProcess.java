package baseball.ballcount;

import baseball.game.Game;
import baseball.game.GameProcess;

public class BaseballGameProcess implements GameProcess {

    @Override
    public void checkGameContinue(String gameContinue, Game game, GameProcess gameProcess) {
        if(gameContinue.equals("1")) {
            game.execute(gameProcess);
        }
    }
}

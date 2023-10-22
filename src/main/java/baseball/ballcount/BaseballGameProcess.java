package baseball.ballcount;

import baseball.Computer;
import baseball.game.Game;
import baseball.game.GameProcess;

public class BaseballGameProcess implements GameProcess {

    @Override
    public void startGame(Game game) {
        String computeValue = Computer.createValue();
        game.execute(computeValue);
    }
}

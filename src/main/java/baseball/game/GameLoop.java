package baseball.game;

import baseball.context.BaseballContext;
import baseball.game.dto.Baseball;
import baseball.game.dto.BaseballMatchResults;
import baseball.io.Input;

public class GameLoop {

    private final Input input;
    private final BaseballContext baseballContext;
    private final BaseballGame baseballGame;

    public GameLoop(Input input, BaseballContext baseballContext, BaseballGame baseballGame) {
        this.input = input;
        this.baseballContext = baseballContext;
        this.baseballGame = baseballGame;
    }

    public void run() {
        while (baseballContext.isRunning()) {
            String balls = input.nextLine();
            BaseballMatchResults matchResults =
                baseballGame.match(Baseball.of(baseballContext.getAnswer()), Baseball.of(balls));
        }
    }
}

package baseball.game;

import baseball.context.BaseballContext;

import baseball.context.GameLifeCycle;
import baseball.game.dto.Baseball;
import baseball.game.dto.BaseballScore;
import baseball.io.input.Input;
import baseball.io.input.validation.InputValidator;
import baseball.io.output.OutputMessages;

public class GameLoop {

    private final Input input;
    private final BaseballContext baseballContext;
    private final BaseballGame baseballGame;
    private final GameLifeCycle gameLifeCycle;

    public GameLoop(Input input, BaseballContext baseballContext, BaseballGame baseballGame) {
        this.input = input;
        this.baseballContext = baseballContext;
        this.baseballGame = baseballGame;
        this.gameLifeCycle = baseballContext.getGameLifeCycle();
    }

    private void promptRestart() {
        System.out.println(OutputMessages.FINISH_GAME_MESSAGE);
        System.out.println(OutputMessages.RESTART_GAME_MESSAGE);
        String select = input.nextLine();
        if (select.equals("1")) {
            baseballContext.regenerateAnswer();
            return;
        }
        gameLifeCycle.finish();
    }

    public void run() {
        System.out.println(OutputMessages.WELCOME_MESSAGE);
        while (gameLifeCycle.isRunning()) {
            System.out.print(OutputMessages.INPUT_MESSAGE);
            String balls = input.nextLineWithValidation(InputValidator.singleton());
            Baseball computerBall = Baseball.of(baseballContext.getAnswer());
            Baseball myBall = Baseball.of(balls);
            BaseballScore matchResults = baseballGame.match(computerBall, myBall);
            System.out.print(matchResults);

            if (matchResults.isStrike()) {
                promptRestart();
            }
        }
    }
}

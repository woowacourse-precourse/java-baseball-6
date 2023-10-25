package baseball.play;

import baseball.controller.BaseballController;
import baseball.resolver.BaseballViewResolver;
import baseball.setting.ReadyGame;

public class GameMachine {


    BaseballViewResolver baseballViewResolver = new BaseballViewResolver();
    private int gameResult;
    private static final int END_NUMBER = 2;
    private static final int RE_GAME_NUMBER = 1;

    public void play() {
        while (true) {
            ReadyGame readyGame = new ReadyGame();

            baseballViewResolver.startView();
            BaseballController controller = readyGame.injection();
            engin(controller);
            if (gameResult == END_NUMBER) {
                baseballViewResolver.endGame();
                break;
            }
        }
    }

    private void engin(BaseballController controller) {
        do {
            gameResult = baseballViewResolver.contactViewAndResultController(
                controller.startBaseBall(
                    baseballViewResolver.contactViewAndPlayControl()
                ));

        } while (gameResult != END_NUMBER && gameResult != RE_GAME_NUMBER);
    }
}
package baseball.play;

import baseball.controller.BaseballController;
import baseball.resolver.BaseballViewResolver;
import baseball.setting.ReadyGame;

public class GameMachine {

    BaseballViewResolver baseballViewResolver = new BaseballViewResolver();
    private int gameResult;

    public void play() {
        while (true) {
            ReadyGame readyGame = new ReadyGame();

            baseballViewResolver.startView();
            BaseballController controller = readyGame.injection();
            engin(controller);
            if (gameResult == 2) {
                baseballViewResolver.endGame();
                break;
            }
        }
    }

    private void engin(BaseballController controller) {
        while (true) {
           gameResult = baseballViewResolver.contactViewAndResultController(
                controller.startBaseBall(
                    baseballViewResolver.contactViewAndPlayControl()
                ));

            if (gameResult == 2 || gameResult == 1) {
                break;
            }
        }
    }
}
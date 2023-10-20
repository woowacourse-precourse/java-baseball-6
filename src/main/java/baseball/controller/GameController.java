package baseball.controller;

import static baseball.converter.BaseBallConverter.stringToOverallGameStatus;

import baseball.domain.player.Computer;
import baseball.enums.OverallGameStatus;
import baseball.view.BaseBallView;


public class GameController {


    private static final BaseBallView baseBallView  = BaseBallView.create();

    private GameController() {
    }

    public static void run() {
        baseBallView.startGameView();

        OverallGameStatus overallGameStatus = OverallGameStatus.CONTINUE;

        while (overallGameStatus.isContinue()) {
            Computer computer = Computer.create();

            PlayerController.startBattle(computer.getPlayer());

            overallGameStatus = stringToOverallGameStatus(baseBallView.continueInputView());
        }
    }

}

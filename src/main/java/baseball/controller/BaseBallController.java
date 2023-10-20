package baseball.controller;

import static baseball.converter.BaseBallConverter.stringToNumbers;
import static baseball.converter.BaseBallConverter.stringToOverallGameStatus;

import baseball.domain.Computer;
import baseball.domain.Numbers;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.enums.OverallGameStatus;
import baseball.view.BaseBallView;
import baseball.view.ConsolePrint;


public class BaseBallController {

    private BaseBallView baseBallView;
    private Computer computer;
    private Player player;



    public void run() {
        init();
        startMainGame();
    }

    private void init() {
        baseBallView = BaseBallView.create();
        computer = Computer.create();
        player = Player.create();
    }

    private void startMainGame() {
        baseBallView.startGameView();

        OverallGameStatus overallGameStatus = OverallGameStatus.CONTINUE;

        while (overallGameStatus.isContinue()) {
            computer.resetNumbers();

            startSubGame();

            overallGameStatus = stringToOverallGameStatus(baseBallView.continueInputView());
        }
    }

    private void startSubGame() {
        boolean continueGame = Boolean.TRUE;

        while (continueGame) {
            Numbers numbers = stringToNumbers(baseBallView.numbersInputView());
            player.changeNumbers(numbers);

            Result result = computer.calculateResult(player);
            ConsolePrint.printResult(result);

            continueGame = result.isContinue();
        }
    }

}

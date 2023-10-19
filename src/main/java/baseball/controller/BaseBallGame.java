package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.io.Input;
import baseball.io.Output;


public class BaseBallGame {


    private Computer computer;
    private Player player;


    public void run() {
        Output.printStart();

        boolean restart = Boolean.TRUE;

        while (restart) {
            computer = Computer.create();
            player = Player.create();

            startGame();

            Output.printFinish();
            restart = Input.inputRestartGame();
        }
    }

    private void startGame() {
        boolean continueGame = Boolean.TRUE;

        while (continueGame) {
            Output.printNumberInput();
            player.inputNumber();

            Result result = computer.calculateResult(player);
            Output.printResult(result);

            continueGame = result.isContinue();
        }
    }




}

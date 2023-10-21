package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    Computer computer = new Computer();
    Player player = new Player();
    public void startGame(){
        OutputView.baseballGameStart();
        System.out.println(computer.getComputerNumber());
        player.inputPlayerNumber(InputView.playerNumber());
        System.out.println(player.getPlayerNumber());

    }
}

package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    Computer computer = new Computer();
    Player player = new Player();
    Referee referee = new Referee();
    public void startGame(){
        OutputView.baseballGameStart();
        System.out.println(computer.getComputerNumber());
        player.inputPlayerNumber(InputView.playerNumber());
        System.out.println(player.getPlayerNumber());
        referee.duplicateNumbers(computer.getComputerNumber(), player.getPlayerNumber());
        System.out.println("스트라이크 : "+ referee.getStrike()+" 볼 : "+ referee.getBall());
        OutputView.detailMessage(referee.getStrike(), referee.getBall());
    }
}

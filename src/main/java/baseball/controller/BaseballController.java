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
        matchGame();

    }

    public void matchGame() {
        computer.drawComputerNumber();
        System.out.println(computer.getComputerNumber());
        while(true){
            player.inputPlayerNumber(InputView.playerNumber());
            System.out.println(player.getPlayerNumber());
            referee.duplicateNumbers(computer.getComputerNumber(), player.getPlayerNumber());
            System.out.println("스트라이크 : "+ referee.getStrike()+" 볼 : "+ referee.getBall());
            OutputView.detailMessage(referee.getStrike(), referee.getBall());
            if (outPlayer(referee.getStrike())) break;
        }
    }

    public boolean outPlayer(int strike) {
        if(strike == 3){
            OutputView.threeStrikeMessage();
            return true;
        }
        return false;
    }
}

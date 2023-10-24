package baseball.controller;

import baseball.model.PlayerNum;
import baseball.model.ComputerNum;
import baseball.model.Referee;
import baseball.view.OutputView;
import baseball.view.InputView;

public class BaseballGame {
    private final ComputerNum computer;
    private final PlayerNum player;
    private final Referee referee;

    public BaseballGame() {
        computer = new ComputerNum();
        player = new PlayerNum();
        referee = new Referee();
    }

    private void printCount(int ball, int strike) {
        if(ball == 0 && strike == 0){
            OutputView.printNothing();
        }else if(ball == 0) {
            OutputView.printStrike(strike);
        }else if(strike == 0) {
            OutputView.printBall(ball);
        }else {
            OutputView.printBallWithStrike(ball, strike);
        }
    }

    public void gameStart() {
        computer.initComputerNum();
        computer.createComputerNum();
        do {
            player.initPlayerNum();
            referee.initReferee();
            player.setPlayerNum(InputView.inputUserNum());
            referee.countBallAndStrike(computer.getComputerNum(), player.getPlayerNum());
            printCount(referee.getBall(), referee.getStrike());
        } while(!referee.isThreeStrike());
    }

    public boolean restartFlag(){
        return InputView.inputRetryNum().equals("1");
    }
}

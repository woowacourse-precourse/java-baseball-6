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
        checkRestart();
    }
    public void checkRestart(){
        while(true){
            startPlayGame();
            player.answerRestartOrEnd(InputView.restartOrEndGame());
            if(isAnswerEnd(player.getAnswerNumber())) break;
        }
    }

    public void startPlayGame() {
        computer.drawComputerNumber();
        matchGame();
    }

    private void matchGame() {
        while(true){
            player.inputPlayerNumber(InputView.playerNumber());
            referee.duplicateNumbers(computer.getComputerNumber(), player.getPlayerNumber());
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
    public boolean isAnswerEnd(Integer answerNumber) {
        return answerNumber == 2 ? true : false ;
    }
}

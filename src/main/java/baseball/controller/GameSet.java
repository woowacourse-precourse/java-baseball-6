package baseball.controller;

import baseball.model.CompareNumber;
import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Arrays;

public class GameSet {

    private ComputerNumber computer;
    private PlayerNumber playerNumber;
    private boolean reGame = true;
    private boolean success = false;
    private CompareNumber compareNumber;

    public void gameStart(){
        compareNumber = new CompareNumber();
        OutputView.startMessage();
        do{
            computer = new ComputerNumber();
            answerCheck();
            reGame = reStartOrOver();
        }while(reGame);
    }

    public void answerCheck(){
        do{
            playerNumber = new PlayerNumber(InputView.playerNumber());
            int[] result = compareNumber.getResult(playerNumber.getPlayerNumber(), computer.getComputerNumber());
            success = compareNumber.successCheck(result);
            OutputView.resultCheck(result);
        }while(!success);
    }

    public boolean reStartOrOver(){
        String check = InputView.reStartOrOverNumber();
        if (check.equals("2")) return false;
        return true;
    }
}

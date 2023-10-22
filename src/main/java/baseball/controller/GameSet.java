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
    private int reGame = 1;
    private CompareNumber compareNumber;

    public void gameStart(){
        compareNumber = new CompareNumber();
        do{
            OutputView.startMessage();
            computer = new ComputerNumber();
            answerCheck();
        }while(reGame == 1);
    }

    public void answerCheck(){
        do{
            playerNumber = new PlayerNumber(InputView.playerNumber());
            int[] result = compareNumber.getResult(playerNumber.getPlayerNumber(), computer.getComputerNumber());
            OutputView.resultCheck(result);
        }while(true);
    }
}

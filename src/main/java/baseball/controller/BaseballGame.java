package baseball.controller;

import baseball.model.Comparer;
import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import static constant.MessageList.NONE;
import static constant.MessageList.THREE_STRIKE;

public class BaseballGame {
    private final ComputerNumber computer;
    private final PlayerNumber player;
    private final Comparer comparer;
    public BaseballGame(){
        computer = new ComputerNumber();
        player = new PlayerNumber(InputView.getNumberFromPlayer());
        comparer = new Comparer();
    }

    public void start(){
        do{
            InputView.getNumberFromPlayer();
            printResult(comparer.calculateStrikeOrBallOrNothing(computer.getComputerNumber(), player.playerNumber));
        } while(!isThreeStrike());
    }
    public void printResult(int[] ballOrStrikeCount){
        printBallCount(ballOrStrikeCount);
        printStrikeCount(ballOrStrikeCount);
        printNothingCount(ballOrStrikeCount);
    }
    public boolean isThreeStrike(){
        if (comparer.calculateStrikeOrBallOrNothing(computer.getComputerNumber(), player.playerNumber)[1] == THREE_STRIKE){
            OutputView.printSuccessMessage();
            return true;
        }
        return false;
    }
    public void printBallCount(int[] ballOrStrikeCount){
        if (ballOrStrikeCount[0] != NONE){
            OutputView.printCount(ballOrStrikeCount[0]);
            OutputView.printBallMessage();
        }
    }
    public void printStrikeCount(int[] ballOrStrikeCount){
        if (ballOrStrikeCount[1] != NONE){
            OutputView.printCount(ballOrStrikeCount[1]);
            OutputView.printStrikeMessage();
        }
    }
    public void printNothingCount(int[] ballOrStrikeCount){
        if (ballOrStrikeCount[0] == NONE && ballOrStrikeCount[1] == NONE){
            OutputView.printNothingMessage();
        }
    }
}
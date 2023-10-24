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
    private PlayerNumber player;
    private Comparer comparer;
    public BaseballGame(){
        computer = new ComputerNumber();
    }

    public void start(){
        do{
            getNumberFromPlayer();
            setComparer();
            printResult(comparer.calculateBallOrStrikeOrNothing(computer.getComputerNumber(), player.getPlayerNumber()));
        } while(!isThreeStrike());
    }
    public void getNumberFromPlayer(){
        player = new PlayerNumber(InputView.getNumberFromPlayer());
    }
    public void setComparer(){
        comparer = new Comparer(computer.getComputerNumber(), player.getPlayerNumber());
    }
    public void printResult(int[] ballOrStrikeCount){
        printBallCount(ballOrStrikeCount[0]);
        printStrikeCount(ballOrStrikeCount[1]);
        printNothingCount(ballOrStrikeCount[0], ballOrStrikeCount[1]);
    }
    public boolean isThreeStrike(){
        if (comparer.getStrikeCount() == THREE_STRIKE){
            OutputView.printSuccessMessage();
            return true;
        }
        return false;
    }
    public void printBallCount(int ballCount){
        if (ballCount != NONE){
            OutputView.printCount(ballCount);
            OutputView.printBallMessage();
        }
    }
    public void printStrikeCount(int strikeCount){
        if (strikeCount != NONE){
            OutputView.printCount(strikeCount);
            OutputView.printStrikeMessage();
        }
    }
    public void printNothingCount(int ballCount, int strikeCount){
        if (ballCount == NONE && strikeCount == NONE){
            OutputView.printNothingMessage();
        }
    }
}
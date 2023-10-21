package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.SuccessCheck;
import baseball.view.Input;
import baseball.view.Output;

public class GameManage {
    private final ComputerNumber computerNum;
    private PlayerNumber playerNum;
    private final SuccessCheck successCheck;

    public GameManage() {
        computerNum = new ComputerNumber();
        successCheck = new SuccessCheck();
    }

    public void gameStart() {
        do {
            getNumOfPlayer();
            printResult(getCompareNumber());
        } while (!isDone());
    }

    public void getNumOfPlayer() {
        playerNum = new PlayerNumber(Input.setPlayerNumber());
    }

    public int[] getCompareNumber() {
        return successCheck.CheckOfSuccess(computerNum.getComputerNumber(), playerNum.playerNumber());
    }

    public void printResult(int[] compareResult) {
        printBallMessage(compareResult);
        printStrikeMessage(compareResult);
        printNothingMessage(compareResult);
    }

    public void printBallMessage(int[] compareResult) {
        if (compareResult[0] != 0) {
            if (compareResult[1] != 0) {
                Output.num(compareResult[0]);
                Output.ballMessage();
                Output.space();
            } else {
                Output.num(compareResult[0]);
                Output.ballMessage();
                Output.line();
            }
        }
    }

    public void printStrikeMessage(int[] compareResult) {
        if (compareResult[1] != 0) {
            Output.num(compareResult[1]);
            Output.strikeMessage();
        }
    }

    public void printNothingMessage(int[] compareResult) {
        if (compareResult[0] == 0 && compareResult[1] == 0) {
            Output.nothingMessage();
        }
    }

    public boolean isDone() {
        if (successCheck.isSuccess()) {
            Output.gameSuccess();
            return true;
        } else {
            return false;
        }
    }
}

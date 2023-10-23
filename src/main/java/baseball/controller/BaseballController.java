package baseball.controller;

import baseball.PlayGame;
import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    public static final OutputView outputView = new OutputView();
    public static final InputView inputView = new InputView();
    public static final ComputerNumber computerNumber = new ComputerNumber();
    public static final PlayerNumber playerNumber = new PlayerNumber();
    public static final PlayGame playGame = new PlayGame();
    private List<Integer> coumputerNumberList;
    private List<Integer> playerNumberList;

    public void startGame() {
        outputView.printStart();
        playGame();
    }

    public void playGame() {
        coumputerNumberList = computerNumber.generateNumber();
        while (true) {
            playerNumberList = playerNumber.playerNumberToList(inputView.inputPlayerNumber());
            int strike = playGame.checkStrike(coumputerNumberList, playerNumberList);
            int ball = playGame.checkBall(coumputerNumberList, playerNumberList);
            boolean result = judgeResult(strike,ball);
        }
    }
    public boolean judgeResult(int strike, int ball) {
        if(strike==0 && ball==0) {
            outputView.printNothing();
            return true;
        }
        if(strike<3 && ball==0) {
            outputView.printStrike(strike);
            return true;
        }
        if(strike==0 && ball!=0) {
            outputView.printBall(ball);
            System.out.println();
            return true;
        }
        if(strike!=0 && ball!=0) {
            outputView.printBall(ball);
            outputView.printStrike(strike);
            return true;
        }
        if(strike==3) {
            outputView.printWin();
            return false;
        }
        return false;
    }
}

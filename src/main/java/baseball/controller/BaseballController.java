package baseball.controller;

import baseball.PlayGame;
import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    public static OutputView outputView = new OutputView();
    public static InputView inputView = new InputView();
    public static ComputerNumber computerNumber = new ComputerNumber();
    public static PlayerNumber playerNumber = new PlayerNumber();
    public static PlayGame playGame = new PlayGame();
    private List<Integer> coumputerNumberList;
    private List<Integer> playerNumberList;
    private int strike = 0;
    private int ball = 0;

    public void startGame() {
        outputView.printStart();
        playGame();
    }

    public void playGame() {
        coumputerNumberList = computerNumber.generateNumber();
        while (true) {
            strike = 0;
            ball = 0;
            playerNumberList = playerNumber.playerNumberToList(inputView.inputPlayerNumber());
            strike = playGame.checkStrike(coumputerNumberList, playerNumberList);
            if(strike!=3) {
                ball = playGame.checkBall(coumputerNumberList, playerNumberList);
            }
            boolean result = judgeResult(strike,ball);
            if(!result) {
                break;
            }
        }
        gameOption();
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
            System.out.print(" ");
            outputView.printStrike(strike);
            return true;
        }
        if(strike==3) {
            outputView.printStrike(strike);
            outputView.printWin();
            return false;
        }
        return false;
    }

    public void gameOption() {
        String option = inputView.inputGameOption();
        if(option.equals("1")) {
            playGame();
        }
    }
}

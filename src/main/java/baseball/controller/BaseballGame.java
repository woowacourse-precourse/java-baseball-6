package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.util.CompareNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {
    private ComputerNumber computerNumber;
    private PlayerNumber playerNumber;
    private CompareNumber compareNumber;

    public BaseballGame(){
        computerNumber = new ComputerNumber();
        playerNumber = new PlayerNumber();
        compareNumber = new CompareNumber();
    }

    public void start() {
        OutputView.gameStartMessage();
        do {
            getPlayerNumber();
            printCount();
        } while (!isGameOver());
    }

    public void getPlayerNumber(){
        String playerInput = InputView.setPlayerNumber();
        playerNumber.setPlayerNumber(playerInput);
    }

    public void printCount(){
        List<Integer> playerNumbers = playerNumber.getPlayerNumber();
        List<Integer> computerNumbers = computerNumber.getComputerNumber();
        compareNumber.countStrikeAndBall(computerNumbers, playerNumbers);

        int ball = compareNumber.getBallCount();
        int strike = compareNumber.getStrikeCount();

        if(ball > 0 && strike > 0){
            OutputView.printBallAndStrike(ball, strike);
        }
        if(ball == 0 && strike > 0){
            OutputView.printOnlyStrike(ball, strike);
        }
        if(ball > 0 && strike == 0){
            OutputView.printOnlyBall(ball, strike);
        }
        if(ball == 0 && strike == 0){
            OutputView.printNothing(ball, strike);
        }
    }

    public boolean isGameOver() {
        int strike = compareNumber.getStrikeCount();

        if (strike == 3) {
            OutputView.gameOverMessage();
            return true;
        }
        return false;
    }

    public void restartGame(){
        computerNumber.reset();
        playerNumber = new PlayerNumber();
        compareNumber = new CompareNumber();
    }
}

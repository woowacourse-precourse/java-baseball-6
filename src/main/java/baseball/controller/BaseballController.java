package baseball.controller;

import baseball.model.ComputerModel;
import baseball.model.UserModel;
import baseball.model.Util;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.stream.Stream;

public class BaseballController {
    int strikeCount;
    int ballCount;

    public void startGame(){
        do {
            playGame();
        } while (isExitGame());
    }

    public void playGame(){
        int[] computerNumbers = new ComputerModel().computerNumbers;
        do {
            int[] userNumbers = new UserModel().numbers;
            strikeCount = countStrike(computerNumbers, userNumbers);
            ballCount = countBall(computerNumbers, userNumbers);
            OutputView outputView = new OutputView(strikeCount, ballCount);
            outputView.outputResult();
        } while (!isClearGame());
        OutputView.printGameResult();
    }

    private boolean isExitGame(){
        String answerNumber = InputView.inputRestart();
        if (answerNumber.equals("1")) {
            return true;
        }
        if (answerNumber.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private boolean isClearGame(){
        return this.strikeCount == 3;
    }

    private int countStrike(int[] computerNumbers, int[] userNumbers){
        return (int) Stream.iterate(0, i -> i < 3, i -> i + 1)
                .filter(i -> computerNumbers[i] == userNumbers[i])
                .count();
    }

    private int countBall(int[] computerNumbers, int[] userNumbers){
        return (int) Stream.iterate(0, i -> i < 3, i -> i + 1)
                .filter(i -> computerNumbers[i] != userNumbers[i] && Util.isNumberInArray(userNumbers[i], computerNumbers))
                .count();
    }


}

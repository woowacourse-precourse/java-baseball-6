package baseball.controller;

import baseball.model.ComputerModel;
import baseball.model.UserModel;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    public void startGame(){
        int strikeCount;
        int ballCount;
        boolean gameClear;
        do {
            int[] computerNumbers = new ComputerModel().computerNumbers;
            gameClear = false;
            do {
                int[] userNumbers = new UserModel().numbers;
                strikeCount = countStrike(computerNumbers, userNumbers);
                ballCount = countBall(computerNumbers, userNumbers);
                OutputView outputView = new OutputView(strikeCount, ballCount);
                outputView.outputResult();
                if (strikeCount == 3) gameClear = true;
            } while (!gameClear);
        } while (endGame());
    }

    public boolean endGame(){
        String answerNumber = InputView.inputRestart();
        if (answerNumber.equals("1")) {
            return true;
        }
        if (answerNumber.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    private int countStrike(int[] computerNumbers, int[] userNumbers){
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) strikeCount++;
        }
        return strikeCount;
    }

    private int countBall(int[] computerNumbers, int[] userNumbers){
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] != userNumbers[i]) {
                for(int j = 0; j < 3; j++){
                    if (i != j && computerNumbers[j] == userNumbers[i]) {
                        ballCount++;
                    }
                }
            }
        }
        return ballCount;
    }


}

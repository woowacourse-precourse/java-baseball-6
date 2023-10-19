package baseball.controller;

import baseball.domain.BaseballRandomNumberGenerator;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    OutputView outputView = new OutputView();
    public void baseballGame(){
        startGame();
        playGame();
    }
    private void startGame(){
        outputView.printGameStart();
    }
    private void playGame(){

        BaseballRandomNumberGenerator numberGenerator = new BaseballRandomNumberGenerator();
        List<Integer> randomNumbers = numberGenerator.generateRandomNumber();

    }
}

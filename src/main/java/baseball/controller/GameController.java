package baseball.controller;

import baseball.model.entity.BaseballNumber;
import baseball.view.InputView;

public class GameController {
    private InputView inputView = new InputView();
    BaseballNumber baseballNumber = new BaseballNumber();
//    private OutView outView = new OutView();
    public void startGame() {


    }
    private void getInputNumbers() {
        try {
            String input = inputView.inputNumbers();
            baseballNumber = new BaseballNumber(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("");
        }
    }
}

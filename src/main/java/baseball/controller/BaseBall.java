package baseball.controller;

import baseball.model.InputNumbers;
import baseball.view.GameView;

public class BaseBall {
    private final GameView gameView;

    public BaseBall() {
        gameView = new GameView();
    }

    public void startBaseBall() {
        gameView.startBaseballGame();
        while (true) {
            String input = gameView.getInput();
            System.out.println("input : " + input);
            InputNumbers inputNumbers = new InputNumbers(input);
            System.out.println("inputNumber : " + inputNumbers);

        }
    }
}

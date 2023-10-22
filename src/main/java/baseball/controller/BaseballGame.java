package baseball.controller;

import baseball.model.Balls;
import baseball.model.Input;
import baseball.view.InputView;

import java.util.Scanner;

public class BaseballGame {

    private static final Scanner SCANNER = new Scanner(System.in);

    public void play() {
        InputView.printStartOfGame();

        Balls balls = getBalls();

    }

    private Balls getBalls() {
        try {
            return new Balls(getInput());
        } catch (IllegalArgumentException e) {
            return getBalls();
        }
    }

    private Input getInput() {
        InputView.demandInput();
        return Input.of(SCANNER.nextLine());
    }
}

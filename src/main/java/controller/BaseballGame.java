package controller;

import model.BallStrikeNothing;
import model.RandomNumber;
import view.InputView;
import view.OutputView;

public class BaseballGame {
    InputView inputView;
    OutputView outputView;
    RandomNumber randomNumber;
    BallStrikeNothing ballStrikeNothing;

    public BaseballGame(InputView inputView, OutputView outputView, RandomNumber randomNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumber = randomNumber;
    }
}

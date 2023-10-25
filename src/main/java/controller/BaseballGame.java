package controller;

import model.BallStrikeNothing;
import model.CompareNumber;
import model.RandomNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BaseballGame {
    InputView inputView;
    OutputView outputView;
    RandomNumber randomNumber;
    BallStrikeNothing ballStrikeNothing;
    List<Integer> computer;

    public BaseballGame(InputView inputView, OutputView outputView, RandomNumber randomNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumber = randomNumber;
    }

    public boolean Play() {
        computer = randomNumber.GenerateRandomNumber();
        while (true) {
            CompareNumber compareNumber = new CompareNumber(inputView.InputUserNumber(), computer);
            compareNumber.CompareComputerAndUser();
            outputView.printResult();

            if (outputView.PrintReStart() == inputView.exit) {
                return false;
            }
        }
    }
}

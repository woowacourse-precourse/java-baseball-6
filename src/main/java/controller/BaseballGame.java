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

    public void start() {
        System.out.println(inputView.GAME_START_MESSAGE);
        while (true) {
            boolean play = Play();
            if (!play) {
                System.out.println(outputView.GAME_SET);
                break;
            }
        }
    }

    public boolean Play() {
        computer = randomNumber.GenerateRandomNumber();
        while (true) {
            CompareNumber compareNumber = new CompareNumber(inputView.InputUserNumber(), computer);
            compareNumber.CompareComputerAndUser();
            outputView.printResult();

            if (ballStrikeNothing.strike == inputView.NUMBER_LENGTH) {
                String code = outputView.PrintReStart();
                if (code.equals(inputView.exit)) {
                    return false;
                } else if(code.equals(inputView.reStart)) {
                    computer = randomNumber.GenerateRandomNumber();
                }
            }
        }
    }
}

package baseball.controller;

import baseball.model.Command;
import baseball.model.GameNumber;
import baseball.service.ScoreCalculator;
import baseball.util.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final ScoreCalculator calculator;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(ScoreCalculator calculator, InputView inputView, OutputView outputView) {
        this.calculator = calculator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        play();
    }

    private void play() {
        GameNumber computer = new GameNumber(RandomNumbersGenerator.generate());
        //TODO: 디버깅 용 출력문 지우기
        System.out.println("computer = " + computer);
        while (true) {
            GameNumber player = new GameNumber(inputView.readGuessNumber());
            int strike = calculator.calculateStrike(computer, player);
            int ball = calculator.calculateBall(computer, player);
            outputView.printResult(strike, ball);
            if (strike == 3) {
                outputView.printGameEndMessage();
                break;
            }
        }
        restart();
    }

    private void restart() {
        Command command = readGameCommand();
        if (Command.QUIT.equals(command)) {
            return;
        }
        if (Command.RESTART.equals(command)) {
            play();
        }
    }

    private Command readGameCommand() {
        String value = inputView.readGameCommand();
        return Command.fromValue(value);
    }
}

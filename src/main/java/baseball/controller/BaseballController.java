package baseball.controller;

import baseball.constant.Hint;
import baseball.model.Command;
import baseball.model.GameNumber;
import baseball.model.Score;
import baseball.service.ScoreCalculator;
import baseball.util.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Map;

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
        while (true) {
            GameNumber computer = new GameNumber(RandomNumbersGenerator.generate());
            //TODO: 디버깅 용 출력문 지우기
            System.out.println("computer = " + computer);
            guess(computer);
            
            //TODO: 분리가 필요해 보여
            Command command = readGameCommand();
            if (isRestart(command)) {
                continue;
            }
            if (isQuit(command)) {
                return;
            }
        }
    }

    private boolean isQuit(Command command) {
        return Command.isQuit(command);
    }

    private boolean isRestart(Command command) {
        return Command.isRestart(command);
    }

    private void guess(GameNumber computer) {
        while (true) {
            GameNumber player = new GameNumber(inputView.readGuessNumber());
            Score score = calculateScore(computer, player);
            outputView.printScore(score);
            if (isCorrect(score)) {
                break;
            }
        }
        outputView.printGameEndMessage();
    }

    private Score calculateScore(GameNumber computer, GameNumber player) {
        int strike = calculator.calculateStrike(computer, player);
        int ball = calculator.calculateBall(computer, player);
        return new Score(Map.of(Hint.STRIKE, strike, Hint.BALL, ball));
    }

    private Command readGameCommand() {
        String value = inputView.readGameCommand();
        return Command.fromValue(value);
    }

    private Boolean isCorrect(Score score) {
        if (score == null) {
            return false;
        }
        return score.isStrikeOut();
    }
}

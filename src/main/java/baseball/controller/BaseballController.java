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
        GameNumber computer = new GameNumber(RandomNumbersGenerator.generate());
        //TODO: 디버깅 용 출력문 지우기
        System.out.println("computer = " + computer);
        guess(computer);
        restart();
    }

    //TODO: 재귀 에러 발생하는지 확인
    private void guess(GameNumber computer) {
        GameNumber player = new GameNumber(inputView.readGuessNumber());
        Score score = calculateScore(computer, player);
        outputView.printScore(score);
        if (score.isStrikeOut()) {
            outputView.printGameEndMessage();
            return;
        }
        guess(computer);
    }

    private Score calculateScore(GameNumber computer, GameNumber player) {
        int strike = calculator.calculateStrike(computer, player);
        int ball = calculator.calculateBall(computer, player);
        return new Score(Map.of(Hint.STRIKE, strike, Hint.BALL, ball));
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

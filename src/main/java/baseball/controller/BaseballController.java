package baseball.controller;

import baseball.model.GameNumber;
import baseball.service.ScoreCalculator;
import baseball.util.Converter;
import baseball.util.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

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
            GameNumber player = new GameNumber(readGuessNumber());
            int strike = calculator.calculateStrike(computer, player);
            int ball = calculator.calculateBall(computer, player);
            outputView.printResult(strike, ball);
            if (strike == 3) {
                outputView.printGameEndMessage();
                break;
            }
        }
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("1")) {
            play();
            return;
        }
        if (gameCommand.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("재시작/종료 명령이 잘못되었습니다.");
    }

    // TODO: 과연 여기에 검증로직이 있는게 맞는지 고민해보기
    private List<Integer> readGuessNumber() {
        String value = inputView.readGuessNumber();
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        return Converter.convertList(value);
    }
}

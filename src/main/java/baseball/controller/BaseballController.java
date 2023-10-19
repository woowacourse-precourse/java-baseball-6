package baseball.controller;

import baseball.service.ScoreCalculator;
import baseball.util.Converter;
import baseball.util.RandomNumbersGenerator;
import baseball.validator.NumbersValidation;
import baseball.validator.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {

    private ScoreCalculator calculator;
    private Validator validator = new NumbersValidation(); //TODO: DI로 구성해보기

    private final InputView inputView;
    private final OutputView outputView;

    public BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        play();
    }

    private void play() {
        List<Integer> computer = RandomNumbersGenerator.generate();
        //TODO: 디버깅 용 출력문 지우기
        System.out.println("computer = " + computer);

        while (true) {
            String guessNumber = readGuessNumber();
            List<Integer> player = Converter.convertList(guessNumber);
            this.calculator = new ScoreCalculator(computer, player);
            int strike = calculator.calculateStrike();
            int ball = calculator.calculateBall();
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

    private String readGuessNumber() {
        String value = inputView.readGuessNumber();
        validator.validate(value);
        return value;
    }
}

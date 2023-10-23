package baseball;

import baseball.controller.GameController;
import baseball.global.converter.NumbersConverter;
import baseball.global.view.input.InputView;
import baseball.global.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        NumbersConverter numbersConverter = new NumbersConverter();

        GameController gameController = new GameController(inputView, outputView, numbersConverter);

        gameController.run();


    }
}

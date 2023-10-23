package baseball;

import baseball.controller.BaseballController;
import baseball.io.InputReader;
import baseball.io.OutputWriter;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        createBaseballController().run();
    }

    private static BaseballController createBaseballController() {
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();

        InputView inputView = new InputView(inputReader, outputWriter);
        OutputView outputView = new OutputView(outputWriter);

        BaseballService baseballService = new BaseballService();

        return new BaseballController(inputView, outputView, baseballService);
    }
}

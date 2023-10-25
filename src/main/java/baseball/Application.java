package baseball;

import baseball.controller.BaseballController;
import baseball.io.InputReader;
import baseball.io.OutputWriter;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final InputReader inputReader = new InputReader();
    private static final OutputWriter outputWriter = new OutputWriter();

    public static void main(String[] args) {
        createBaseballController().run();

        releaseResource();
    }

    private static BaseballController createBaseballController() {
        InputView inputView = new InputView(inputReader, outputWriter);
        OutputView outputView = new OutputView(outputWriter);
        BaseballService baseballService = new BaseballService();
        return new BaseballController(inputView, outputView, baseballService);
    }

    private static void releaseResource() {
        Console.close();
    }
}

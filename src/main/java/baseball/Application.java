package baseball;

import baseball.controller.BaseballController;
import baseball.io.InputReader;
import baseball.io.OutputWriter;
import baseball.service.BaseballService;
import baseball.view.BaseballView;

public class Application {
    public static void main(String[] args) {
        createBaseballController().run();
    }

    private static BaseballController createBaseballController() {
        BaseballService baseballService = new BaseballService();
        BaseballView baseballView = createBaseballView();

        return new BaseballController(baseballService, baseballView);
    }

    private static BaseballView createBaseballView() {
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        return new BaseballView(inputReader, outputWriter);
    }
}

package baseball;

import baseball.controller.GameController;
import baseball.util.TypeConvertor;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController(inputView(), outputView());
        controller.run();
    }

    private static InputView inputView() {
        return new InputView(new TypeConvertor());
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}

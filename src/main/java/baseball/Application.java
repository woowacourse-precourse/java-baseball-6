package baseball;

import Controller.MainController;
import View.InputView;
import View.OutputView;
import View.RetryView;

public class Application {

    public static void main(String[] args) {
        MainController controller = new MainController(InputView.getInstance(),
                OutputView.getInstance(),
                RetryView.getInstance());
        controller.run();
    }
}

package baseball;

import controller.Controller;
import views.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printIntro();
        Controller controller = new Controller();
        controller.playGame();

    }
}

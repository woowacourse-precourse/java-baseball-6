package baseball;

import baseball.controller.BaseballController;
import baseball.model.BaseballModel;
import baseball.view.BaseballView;

public class Application {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView();
        BaseballModel baseballModel = new BaseballModel();

        BaseballController baseballController = new BaseballController(baseballView, baseballModel);
        baseballController.play();
    }
}

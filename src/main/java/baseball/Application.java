package baseball;

import baseball.controller.BaseballController;
import baseball.model.BaseballStadium;
import baseball.view.BaseballView;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballView baseballView = new BaseballView(new InputView(), new OutputView());
        BaseballStadium baseballStadium = new BaseballStadium();
        BaseballController baseballController = new BaseballController(baseballStadium, baseballView);
        baseballController.gameStart();
    }
}

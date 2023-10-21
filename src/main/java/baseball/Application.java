package baseball;

import baseball.controller.BaseBallGameController;
import baseball.domain.BaseBallGameService;
import baseball.validator.InputValidate;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGameService baseBallGameService = new BaseBallGameService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidate inputValidate = new InputValidate();
        BaseBallGameController baseBallGameController =
                new BaseBallGameController(inputView, outputView, baseBallGameService, inputValidate);
        
        baseBallGameController.run();
    }
}

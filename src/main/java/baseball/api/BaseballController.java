package baseball.api;

import baseball.application.BaseballGameService;
import baseball.view.OutputView;

public class BaseballController {

    BaseballGameService baseballGameService = new BaseballGameService();

    public void startBaseball() {
        OutputView.printGameStartView();
        baseballGameService.startGame();
    }
}

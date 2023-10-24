package baseball.api;

import baseball.application.BaseballGameService;
import baseball.view.OutputView;

public class BaseballController {

    private final BaseballGameService baseballGameService;

    public BaseballController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    public void startBaseball() {
        OutputView.printGameStartView();
        baseballGameService.startGame();
    }
}

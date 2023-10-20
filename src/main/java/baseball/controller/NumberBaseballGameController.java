package baseball.controller;

import baseball.domain.gamedata.BaseballNumber;
import baseball.domain.gamedata.GameData;
import baseball.domain.GameResult;
import baseball.model.Model;
import baseball.model.ModelConst;
import baseball.service.GameService;
import baseball.view.GameView;

public class NumberBaseballGameController implements GameController {

    private final GameService gameService;
    private final GameView view;
    private final Model model;

    private boolean gameContinue;

    public NumberBaseballGameController(final GameService gameService, final GameView view,
            final Model model) {
        this.gameService = gameService;
        this.view = view;
        this.model = model;
        this.gameContinue = true;
    }

    @Override
    public void run() {
        initGame();

        while(gameContinue) {
            GameResult result = performMainContent();
            printResult(result);
            updateValueOfGameContinue(result);
        }
    }

    private void initGame() {
        gameContinue = true;
        gameService.init();
        view.printGameStartAnnouncement();
    }

    private GameResult performMainContent() {
        view.printAnnouncementForInputAnswer();

        String inputData = receiveUserInput();

        GameData baseballNumber = BaseballNumber.of(inputData);
        return gameService.calculateResult(baseballNumber);
    }

    private void printResult(final GameResult result) {
        model.setAttribute(ModelConst.RESULT, result);
        view.printGameResult();
    }

    private void updateValueOfGameContinue(final GameResult result) {
        if (!result.isCompleted()) {
            return;
        }

        view.printAnnouncementForRestart();
        gameContinue = Menu.restart(receiveUserInput());
        if (gameContinue) {
            gameService.init();
        }
    }

    private String receiveUserInput() {
        view.conveyUserInput();
        return getInputData();
    }

    private String getInputData() {
        return (String) model.getAttribute(ModelConst.INPUT_DATA)
                .orElseThrow(IllegalArgumentException::new);
    }
}

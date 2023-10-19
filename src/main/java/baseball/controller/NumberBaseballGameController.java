package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.GameData;
import baseball.domain.GameResult;
import baseball.model.Model;
import baseball.model.ModelConst;
import baseball.service.GameService;
import baseball.view.GameView;
import java.util.HashMap;

public class NumberBaseballGameController implements GameController {

    private final GameService gameService;
    private final GameView view;

    private boolean gameContinue;

    public NumberBaseballGameController(GameService gameService, GameView view) {
        this.gameService = gameService;
        this.view = view;
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
        Model model = receiveUserInput();

        String inputData = getInputData(model);

        GameData baseballNumber = new BaseballNumber(inputData);
        return gameService.calculateResult(baseballNumber);
    }

    private void printResult(GameResult result) {
        Model model = new Model(new HashMap<>());
        model.setAttribute(ModelConst.RESULT, result);
        view.printGameResult(model);
    }

    private void updateValueOfGameContinue(GameResult result) {
        if (result.missionComplete()) {
            view.printAnnouncementForRestart();
            Model model = view.conveyUserInput();
            gameContinue = Menu.restart(
                    getInputData(model)
            );

        }
    }

    private Model receiveUserInput() {
        return view.conveyUserInput();
    }

    private String getInputData(Model model) {
        return (String) model.getAttribute(ModelConst.INPUT_DATA)
                .orElseThrow(IllegalArgumentException::new);
    }
}

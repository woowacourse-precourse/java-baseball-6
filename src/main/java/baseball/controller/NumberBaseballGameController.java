package baseball.controller;

import baseball.model.Model;
import baseball.service.GameService;
import baseball.view.GameView;

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
        String inputValue = model.getValue();
        BaseballNumber baseballNumber = new BaseballNumber(inputValue);
        return gameService.calculrateResult(baseballNumber);
    }

    private void printResult(GameResult result) {
        view.printGameResult(Model.of(result));
    }

    private void updateValueOfGameContinue(GameReulst result) {
        if (result.missionComplete) {
            view.printAnnouncementForRestart();
            gameContinue = Menu.restart(
                    view.conveyUserInput().getValue()
            );
        }
    }

    private Model receiveUserInput() {
        return view.conveyUserInput();
    }
}

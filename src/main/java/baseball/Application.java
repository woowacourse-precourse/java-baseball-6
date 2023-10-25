package baseball;

import baseball.application.service.GameFacade;
import baseball.domain.service.HintCreateService;
import baseball.domain.service.PredictionCreateService;
import baseball.presentation.GameController;

public class Application {
    public static void main(String[] args) {
        HintCreateService hintCreateService = new HintCreateService();
        PredictionCreateService predictionCreateService = new PredictionCreateService();
        GameFacade gameFacade = new GameFacade(hintCreateService, predictionCreateService);

        GameController gameController = new GameController(hintCreateService, predictionCreateService, gameFacade);
        gameController.init();
        gameController.progress();
    }
}

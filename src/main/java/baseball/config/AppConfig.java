package baseball.config;

import baseball.controller.GameController;
import baseball.controller.NumberBaseballGameController;
import baseball.domain.BaseballNumberMaker;
import baseball.model.Model;
import baseball.service.GameService;
import baseball.service.NumberBaseballGameService;
import baseball.view.GameView;
import baseball.view.NumberBaseballView;

public class AppConfig {

    public static GameController setup() {
        Model model = new Model();
        BaseballNumberMaker baseballNumberMaker = new BaseballNumberMaker();
        GameView view = new NumberBaseballView(model);
        GameService gameService = new NumberBaseballGameService(baseballNumberMaker);
        return new NumberBaseballGameController(
                gameService, view, model);
    }


}
